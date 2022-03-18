package com.crm.ProductTest;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Set;
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

	public class CreateProductWithCampaign {
		WebDriver driver=null;
		@Test(groups="regression")
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
			String ProductName = ce.getStringCellValue();
			Row ro1 = sh.getRow(1);
			Cell ce1 = ro1.getCell(2);
			String Verify = ce1.getStringCellValue();
			Row row = sh.getRow(4);
			Cell cell = row.getCell(1);
			String orgName = cell.getStringCellValue();
			
			
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
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			//step 3: Login
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// step 4: Navigate to contacts
			driver.findElement(By.linkText("Products")).click();
			
			// step 5: click on create contacts
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			
			// step 6: fill mandatory details
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProductName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if (header.contains(Verify)) {
				System.out.println(Verify);
				System.out.println("Succesfully created");
			} else {
				System.out.println(Verify);
				System.out.println("Not created succesfully");
			}
			WebElement we = driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHide_Event')]"));
			Actions aObj=new Actions(driver);
			aObj.moveToElement(we).perform();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			
			String prWind = driver.getWindowHandle();
			
			driver.findElement(By.name("campaignname")).sendKeys(orgName);
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			

			Set<String> win1 = driver.getWindowHandles();
			for (String win : win1) {
				driver.switchTo().window(win);
			}
			driver.findElement(By.linkText("abc")).click();
			
			driver.switchTo().window(prWind);
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			aObj.moveToElement(move).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
		}
}
