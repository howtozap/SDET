package com.crm.PRATICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	@Test
	public void readDataFromExcel() throws EncryptedDocumentException, IOException {
		// step 1: Load excel File
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data.xlsx");
	
	// step 2: Create workbook
	Workbook wb = WorkbookFactory.create(fis);
	
	// Step 3: Get the sheet
	Sheet sh = wb.getSheet("Sheet1");
	
	//Step 4: Get row  
	Row rw = sh.getRow(1);
	
	// Step 5: Get the cell
	Cell ce = rw.getCell(1);
	
	// Step 6: Read the data from cell
	String data = ce.getStringCellValue();
	System.out.println(data);
	}

}
