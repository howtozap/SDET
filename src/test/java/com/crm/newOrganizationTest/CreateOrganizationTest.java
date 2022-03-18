package com.crm.newOrganizationTest;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(GenericLibrary.ListnersImplementationClass.class)
	public class CreateOrganizationTest {
		@Test(groups="regression")
			public void createOrganization() {
			// step 1: launch the browser
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://localhost:8888");
			
			//step 2: login to Application
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//step 3: navigate to organizations link
			driver.findElement(By.linkText("Organizations")).click();
			Assert.fail();
			
			//step 4: click on create organization link
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//step 5: create organization with mandatory field
			driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
			
			//step 6: save
			driver.findElement(By.name("button")).click();
			driver.quit();
				
			}

	}

