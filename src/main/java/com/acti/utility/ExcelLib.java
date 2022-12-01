package com.acti.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
* Class : ExcelLIb
* Desciption:This class is responsible for fetching the data from Excel Sheet
* Developed By : Sripriya (Like tester who writes this code for testing and runs)
* Date: 11/26/2022
* Reviewed By: Sripriya (Manager who reveiws it)
*/




public class ExcelLib {
	
	  XSSFWorkbook wb;
	   
		public ExcelLib (String Excelpath )
		
		{
			try
			{
			 File src = new File(Excelpath);
			   FileInputStream fis = new FileInputStream(src);
			     wb = new XSSFWorkbook(fis);
			}
			catch (Exception e)
			{
				System.out.println("Unable to load the excel file" +e.getMessage());
			}
		}
			
			public int getRowCount(int sheetnum)
			{
				 int count = wb.getSheetAt(sheetnum).getLastRowNum()+1;
			return count;
				
			}
			public int getRowCount(String sheetname)
			{
				 int count = wb.getSheet(sheetname).getLastRowNum()+1;
			return count;
				
			}
			
			public String getCellData(int sheetnum,int row,int col)
			{
				 String data = wb.getSheetAt(0).getRow(row).getCell(col).toString();
				 return data;
				
			}
			public String getCellData(String  sheetname,int row,int col)
			{
				 String data = wb.getSheet(sheetname).getRow(row).getCell(col).toString();
				 return data;
				
			}

	}



