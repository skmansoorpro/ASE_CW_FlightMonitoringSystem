package com.webauto.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBaseConnection {
	
	/**
	 * Fetch data from DB based on the SQL Query passed to this method
	 * 
	 * @param query
	 * @return Query result as Map
	 * @Author Syeda Anees
	 */
   
	private static final Logger log = LogManager.getLogger(DataBaseConnection.class);

	public Map<Integer, Map<String, Object>> fetchData(String query) {
    	
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet;
    	Map<Integer, Map<String,Object>> resultData = new HashMap<Integer, Map<String, Object>>();
    	Map<Integer, Map<String, Object>> treeMapData = new TreeMap<Integer, Map<String, Object>>();
    	
        try 
        {
        	//Connect to the database
        	//Change the connection parameters according to the DB being used in the project
        	connection = DriverManager.getConnection("jdbc:postgresql://database-svast-1.cowv0eodg8i7.us-west-2.rds.amazonaws.com:5432/application", "postgres", "rH2RyZRgOEBRvfDnWJfL");
        	//Create statement to execute
            statement = connection.createStatement();
            //Execute the SQL Query on the DB and fetch the result in resultSet
            resultSet = statement.executeQuery(query);
            
            //resultSet contains a table with the results of the query we just executed
            //Convert the resultSet to an ArrayList, in order to use it in the test cases 
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            int counter = 0;
            
            while (resultSet.next()) {
            	counter++;
                Map<String, Object> row = new HashMap<>(columns);
                
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), resultSet.getObject(i));                 
                }
                           	
                resultData.put(counter, row);
                treeMapData.putAll(resultData);
                
            }        
      
        } 
        catch (SQLException e) {
            log.debug("DB Connection failure!!");
            e.getCause();
            e.getMessage();
            e.printStackTrace();
        }
        
        finally {
        	try {
				statement.close();
			} catch (SQLException e) {
				log.debug("Could not close DB statement, encountered exception!!");
				e.getCause();
				e.getMessage();
				e.printStackTrace();
			}
        	try {
				connection.close();
			} catch (SQLException e) {
				log.debug("Encountered exception while closing DB connection!!");
				e.getCause();
				e.getMessage();
				e.printStackTrace();
			}
        }
        
		return treeMapData;
    }
    
}
	
