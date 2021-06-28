package com.qa.greenmarker.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {
	
	
	
	public static void getData(String testcase) 
	{
		Workbook workbook;
		Sheet sheet;
		
		
		try {
			FileInputStream fis=new FileInputStream("src/main/resources/TestData.xlsx");
			
			workbook=WorkbookFactory.create(fis);
			int sheets=workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				String SheetName=workbook.getSheetName(i);
				System.out.println(SheetName);
				if(SheetName.equalsIgnoreCase("Sheet1"))
				{
					sheet=workbook.getSheetAt(i);
					
					//Sheet is the collection of rows
					
					
					
				}
				
			}
			
			
			
		} catch (IOException | EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
			
			
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testCaseName="testcase";
		
		getData(testCaseName);

	}

}
