package com.crm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;

public class createOrgWithMultipleTestData {
	
	WebDriver driver=null;
	//create object for all utilities
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility fLib=new ExcelFileUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
@Test(dataProvider="orgNameWithMultipleData")
public void createOrgWithMultipleData(String orgName, String indType) throws Throwable {
	String BROWSER=pLib.readDataFromPropertyFile("browser");
	String URL=pLib.readDataFromPropertyFile("url");
	String USERNAME=pLib.readDataFromPropertyFile("username");
	String PASSWORD=pLib.readDataFromPropertyFile("password");
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("Invalid browser");
	}
	
	wLib.waitForPageLoad(driver);
	//wLib.maximizeWindow(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	driver.quit();
}
@DataProvider(name="orgNameWithMultipleData")
public Object[][] getData() throws IOException, Throwable{
	Object[][] obj=fLib.readMultipleDataFromExcelFile("orgNameWithMultipleData");
	return obj;
}
}
