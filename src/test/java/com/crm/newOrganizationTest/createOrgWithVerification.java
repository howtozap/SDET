package com.crm.newOrganizationTest;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Random;
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
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class createOrgWithVerification {
		@Test(groups="regression")
		public void createOrgTest() throws IOException, InterruptedException {
			Random ram=new Random();
			int random = ram.nextInt();
			/*step 1: Read All Necessasry Data*/
			//read from property file
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			// read data from excel
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Org");
			Row ro = sh.getRow(1);
			Cell ce = ro.getCell(2);
			String OrgName = ce.getStringCellValue();
			
			/*Launch the browser*/
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
			
			/* step 4: navigate to organizations field*/
			driver.findElement(By.linkText("Organizations")).click();
			
			// step 5: click on create organization button
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//step 6: fill the mandatory fields
			driver.findElement(By.name("accountname")).sendKeys(OrgName+" "+random);
			WebElement industry = driver.findElement(By.name("industry"));
			Select sObj=new Select(industry);
			sObj.selectByVisibleText("Healthcare");
			Thread.sleep(4000);
			driver.findElement(By.name("button")).click();
			
			// step 7: Logout
			driver.quit();

	}
}
