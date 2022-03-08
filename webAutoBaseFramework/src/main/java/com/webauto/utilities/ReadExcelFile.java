package com.webauto.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author syedaaf
 * Utility to read excel file, row by row, according to the test case name
 */
public class ReadExcelFile {
	
	private static XSSFWorkbook workbook = null;
	private static final Logger log = LogManager.getLogger(ReadExcelFile.class);
	
	/**
	 * @author syedaaf
	 * @param sheetName
	 * @return XSSFSheet which can be used to read data using getData method
	 * 
	 */
	public static XSSFSheet createExcelObject(String sheetName) {

		XSSFSheet sheet = null;
		
		try {

			String projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath + "/src/test/resources/Test_Data/TestDataSheet.xlsx");
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
	 * @author syedaaf
	 * @param testCaseName
	 * @param sheetName - XSSFSheet
	 * @return Map containing all key value pairs which are present for a given testCaseName row in the test data sheet
	 * @throws IOException 
	 * 
	 */
	public static Map<String, Object> getData(String testCaseName, XSSFSheet sheet) throws IOException {
		
		Map<String, Object> rowMap = new HashMap<String, Object>();
			
		try {
			
			int rowCount = sheet.getPhysicalNumberOfRows();			
			
			for (int i = 1; i < rowCount; i++) {
				
				if (sheet.getRow(i).getCell(0).toString().equals(testCaseName)) {
					
					int columns = sheet.getRow(i).getLastCellNum();
					
					for (int j = 1; j < columns; j++) {		
						rowMap.put(sheet.getRow(i).getCell(j).toString(), sheet.getRow(i).getCell(j+1));
						j++;
					}
				break;
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
}
