package com.crm.ProductTest;
	import java.io.FileInputStream;
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
	import org.testng.annotations.Test;

	public class createProductWithCampaignTest {
		WebDriver driver=null;
		@Test
		public void createProduct() throws IOException {
			/* import data from external resource*/
			// step 1: get data from external file
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			// Read data from excel
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\ProductData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Sheet1");
			Row ro = sh.getRow(1);
			Cell ce = ro.getCell(2);
			String ProductName = ce.getStringCellValue();
			Cell cee = ro.getCell(4);
			String headerMatch = cee.getStringCellValue();
			Row roo = sh.getRow(3);
			Cell cell = roo.getCell(2);
			String campaignName = cell.getStringCellValue();
			Cell cel = roo.getCell(3);
			String CampaignVerify = cel.getStringCellValue();
			
			// Step 2: Open the browser
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("Invalid browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			// Step 3: Login
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
			//Step 4: Create a Product
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			driver.findElement(By.name("productname")).sendKeys(ProductName);
			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
			String HEADER = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if (HEADER.contains(headerMatch)) {
				System.out.println(HEADER);
				System.out.println("product is created");
				
			} else {
				System.out.println(HEADER);
				System.out.println("product not created");
			}
			
			// step 5: move to more
			WebElement move = driver.findElement(By.xpath("//img[@style='padding-left:5px']"));
			Actions a=new Actions(driver);
			a.moveToElement(move).perform();
			
			// step 6: click on campaign
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			driver.findElement(By.name("campaignname")).sendKeys(campaignName);
			driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
			String headerr = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerr.contains(CampaignVerify)) {
				System.out.println(CampaignVerify);
				System.out.println(" is created");
			} 
			else {
				System.out.println(CampaignVerify);
				System.out.println(" not verified");
			}
			WebElement we = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions ac=new Actions(driver);
			ac.moveToElement(we).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();	
		}
}
