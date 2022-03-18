package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertyFileUtility {
	/**
	 * This method will provide data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	 String data = pObj.getProperty(key);
	 return data;
}

}
