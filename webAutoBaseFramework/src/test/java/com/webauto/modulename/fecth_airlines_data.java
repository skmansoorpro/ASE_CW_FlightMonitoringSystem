package com.webauto.modulename;
import java.io.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
	public class fecth_airlines_data {

	private static XSSFWorkbook workbook = null;
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(fecth_airlines_data.class);

	/**
	* @author skmansoorpro@gmail.com
	* @param sheetName
	* @return XSSFSheet which can be used to read data using getData method
	*
	*/
	public static XSSFSheet createExcelObject(String sheetName) {

	XSSFSheet sheet = null;

	try {

		//String projectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook("//Users/mansoorahmed/Desktop/HW/ASE/FlightTracking/excel_files/Airlines.xlsx");
		///Users/mansoorahmed/Desktop/HW/ASE/FlightTracking/excel_files
		sheet = workbook.getSheet(sheetName);
	
		log.info("Started reading the excel file.");

	} catch (Exception e) {

		e.getMessage();
		e.getCause();
		log.debug("Exception found while reading excel file: " + e.getMessage());

	}

	return sheet;
	}

	/**
	* @author skmansoorpro
	* @param testCaseName
	* @param sheetName - XSSFSheet
	* @return Map containing all key value pairs which are present for a given testCaseName row in the test data sheet
	* @throws IOException
	*
	*/
	public static Map<String, Object> getData(XSSFSheet sheet) throws IOException {

	Hashtable<String, Object> rowMap = new Hashtable<String, Object>();

	List<Map<String, String>> temp = new LinkedList<Map<String, String>>();

	try {

	int rowCount = sheet.getPhysicalNumberOfRows();
	int columns = sheet.getRow(0).getLastCellNum();

	for (int i = 1; i < rowCount; i++) {
		Map<String, String> row = new LinkedHashMap<String, String>();
		for (int j = 0; j < columns; j++) {
			if (sheet.getRow(i).getCell(j)==null) {
				break;
			} else {
				row.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i).getCell(j).toString());
			}
		}
		temp.add(row);
	}

	Map<String, String> tempMap = new LinkedHashMap<String, String>();
	for (int k = 1; k < rowCount; k++) {
		tempMap = temp.get(k-1);
		
		if(sheet.getRow(k).getCell(0).toString().equalsIgnoreCase(tempMap.get("Airline_Code").toString())){
			rowMap.put(sheet.getRow(k).getCell(0).toString(), temp.get(k-1));
		}
	}

	} catch (Exception e) {

		e.getMessage();
		e.getCause();
		log.debug("Exception found while reading excel file: " + e.getMessage());

	}

		log.info("Completed reading the excel file and returning the Map containing the data.");
		workbook.close();
		return rowMap;


	}

	public static void main(String[] args) throws IOException {

		final XSSFSheet sheet = fecth_airlines_data.createExcelObject("Sheet1");
		Map<String, Object> myData = fecth_airlines_data.getData(sheet);
	
		System.out.println(myData);

	}
}


