package com.crm.newContactTest;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

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
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class createContactTest {
		WebDriver driver=null;
		@Test(groups="smokeSuite")
		public void createContact() throws IOException, InterruptedException {
			/* import data from external source*/
			//step 1: import data from property file
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			// import data from excel sheet
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Contacts");
			Row ro = sh.getRow(1);
			Cell ce = ro.getCell(1);
			String FirstName = ce.getStringCellValue();
			Row ro1 = sh.getRow(1);
			Cell ce1 = ro1.getCell(2);
			String LastName = ce1.getStringCellValue();
			
			
			// step 2: Launch the browser
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			} 
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else  {
				System.out.println("invalid browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			//step 3: Login
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// step 4: Navigate to contacts
			driver.findElement(By.linkText("Contacts")).click();
			
			// step 5: click on create contacts
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			// step 6: fill mandatory details
			WebElement sel = driver.findElement(By.name("salutationtype"));
			Select sObj=new Select(sel);
			sObj.selectByIndex(1);
			driver.findElement(By.name("firstname")).sendKeys(FirstName);
			driver.findElement(By.name("lastname")).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
			WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions aObj=new Actions(driver);
			aObj.moveToElement(signOut).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(4000);
			driver.quit();	
		}
}
