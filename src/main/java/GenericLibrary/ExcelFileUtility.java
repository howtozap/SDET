package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * This method is use to read data from excel sheet
	 * @param SheetName
	 * @param rowNm
	 * @param cellNm
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String SheetName, int rowNm, int cellNm) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNm);
		Cell cell = row.getCell(cellNm);
		String data = cell.getStringCellValue();
		return data;
	}

	
	/**
	 * This method will return last row number
	 * @param SheetName
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String SheetName) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int row=sh.getLastRowNum();
		return row;
	}

	/**
	 * This method will write data into excel sheet in which user will send sheet name, row, cell, and value.
	 * @param SheetName
	 * @param rowNm
	 * @param cellNm
	 * @param value
	 * @throws IOException
	 */
	public void writeDataIntoExcelSheet(String SheetName, int rowNm, int cellNm,String value) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNm);
		Cell cell = row.createCell(cellNm);
		cell.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
	}
	
	public Object[][] readMultipleDataFromExcelFile(String sheetName) throws Throwable, IOException{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		   int lastCell = sh.getRow(0).getLastCellNum();
		   Object[][] data=new Object[lastRow][lastCell];
		   for (int i = 0; i < lastRow; i++) {
			   for (int j = 0; j < lastCell; j++) {
				   
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
			
		}
		return data;
	}
}
