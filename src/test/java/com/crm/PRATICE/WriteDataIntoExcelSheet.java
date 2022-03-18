package com.crm.PRATICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheet {
	@Test
	public void writeDataInExcel() throws EncryptedDocumentException, IOException {
		// step 1: open file in read mode
	FileInputStream fis=new FileInputStream("./src/test/resources/data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);
	
	//CREATE A CELL TO WRITE DATA
	Cell ce = ro.createCell(9);
	
	//SET A CELL VALUE
	ce.setCellValue("tc_1000");
	
	//open the file in write mode
	FileOutputStream fos=new FileOutputStream("./src/test/resources/data.xlsx");
	wb.write(fos);
	}

}
