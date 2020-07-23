package com.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	
		
		public ArrayList<String> getExcelData(String testCaseName) throws IOException
		{
			
			ArrayList<String> al = new	ArrayList<String>();
			FileInputStream fis = new FileInputStream("C:\\Users\\pkodanda\\Desktop\\TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
				{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstrow= row.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k= 0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column = k;
					}
					k++;
					
				}
				while(row.hasNext())
				{
					Row r =row.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
							{
								Iterator<Cell> cv =r.cellIterator();
								while(cv.hasNext())
								{
									al.add((cv.next().getStringCellValue()));
								}
							}
							
				
				}
			
			
		}
		
				
		
	}
			return al;
	
	}
}
