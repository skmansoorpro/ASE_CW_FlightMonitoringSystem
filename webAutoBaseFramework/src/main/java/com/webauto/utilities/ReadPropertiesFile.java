package com.webauto.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadPropertiesFile {

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getPropertiesFromFile("browser")); }
	 */
	
	private static final Logger log = LogManager.getLogger(ReadPropertiesFile.class);
	
	/**
	 * This method is for reading the properties file
	 * @author syedaaf
	 * @param String Key, the key for which you want to fetch the value from properties file
	 * @return String Value
	 * 
	 */
	public static String getPropertiesFromFile(String key) {
		
		String propertyValue = null;
		
		try {
			Properties prop = new Properties();
			String userDir = System.getProperty("user.dir");
			InputStream instr = new FileInputStream(userDir+"/src/main/resources/config.properties");
			prop.load(instr);
			propertyValue = prop.getProperty(key);
			
		} catch (Exception exp) {
			log.debug(exp.getMessage().toString());
			log.debug(exp.getCause().toString());
			exp.printStackTrace();
		}
		
		return propertyValue;
	}
	
}
