package com.webauto.modulename;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.webauto.utilities.ReadExcelFile;

public class Execution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
			Assignment myData = new Assignment();
			XSSFSheet sheet = ReadExcelFile.createExcelObject("Flights");

			//System.out.println(myData.getData("AF670", sheet));
			
			

	}

}
