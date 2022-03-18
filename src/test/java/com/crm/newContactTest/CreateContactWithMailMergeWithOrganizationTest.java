package com.crm.newContactTest;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class CreateContactWithMailMergeWithOrganizationTest {
		@Test
		public void checkCancekBtn() throws EncryptedDocumentException, IOException {
			/* import data from external file*/
			//read from property file
					FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
					Properties pObj=new Properties();
					pObj.load(fis);
					String BROWSER = pObj.getProperty("browser");
					String URL = pObj.getProperty("url");
					String USERNAME = pObj.getProperty("username");
					String PASSWORD = pObj.getProperty("password");
					
					// read data from excel
					FileInputStream fi=new FileInputStream(".\\src\\main\\resources\\AssgnOrganization.xlsx");
					Workbook wb = WorkbookFactory.create(fi);
					Sheet sh = wb.getSheet("Contact");
					Row ro = sh.getRow(1);
					Cell ce = ro.getCell(2);
					String contactName = ce.getStringCellValue();
					Row row1 = sh.getRow(2);
					Cell cell1 = row1.getCell(2);
					String verify = cell1.getStringCellValue();
					Cell rox = ro.getCell(3);
					String Email = rox.getStringCellValue();
					
					//step 2: open browser
					WebDriver driver=null;
					if (BROWSER.equalsIgnoreCase("chrome")) {
						driver=new ChromeDriver();
					} 
					else if(BROWSER.equalsIgnoreCase("firefox")) {
						driver=new FirefoxDriver();
					}
					else {
						System.out.println("Invalid Browser");
					}
					driver.manage().window().maximize();
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.get(URL);
					
					//Step 3: Login
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					driver.findElement(By.id("submitButton")).click();
					
					//step 4: move to contacts
					WebElement contacts = driver.findElement(By.linkText("Contacts"));
					Actions aObj=new Actions(driver);
					aObj.moveToElement(contacts).perform();
					
					/*Done to generate report*/
					//Assert.fail();
					contacts.click();
					
					// Step 5: Navigate to mailmerge module and click
					driver.findElement(By.linkText("Create Mail Merge templates ")).click();
	}

}
