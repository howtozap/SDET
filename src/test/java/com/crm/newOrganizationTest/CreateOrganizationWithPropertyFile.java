package com.crm.newOrganizationTest;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.Test;

	public class CreateOrganizationWithPropertyFile {
		@Test(groups="regionalRegression")
		public void createOrganizationTest() throws IOException, InterruptedException {
			// step 1: read data from property file
			FileInputStream fis=new FileInputStream("./src\\test\\resources\\CommonData.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			//step 2: launch the browser
			WebDriver driver=null;
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			} else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("Invalid Browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			//step 3: Login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//step 4: navigate to organization link
			driver.findElement(By.linkText("Organizations")).click();
			
			// step 5: click on create organization link
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			// step 6: create organization with mandatory field
			driver.findElement(By.name("accountname")).sendKeys("TWO STATES");
			
			// step 7: save
			driver.findElement(By.name("button")).click();
			Thread.sleep(5000);
			
			driver.quit();
		}

	}

