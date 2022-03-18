package com.crm.PRATICE;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPraticeCreateContactUsingLeadSource{
	WebDriver driver;
@Test
public void creatContact() throws InterruptedException, IOException {
	//WebDriverManager.chromedriver().setup();
	// Step 1: import the important data from external file
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelFileUtility ex=new ExcelFileUtility();
	PropertyFileUtility pf=new PropertyFileUtility();
	
	String BROWSER=pf.readDataFromPropertyFile("browser");
	String URL=pf.readDataFromPropertyFile("url");
	String USERNAME=pf.readDataFromPropertyFile("username");
	String PASSWORD=pf.readDataFromPropertyFile("password");
	
	String orgName=ex.readDataFromExcelSheet("Org",4,2);
	String lastname=ex.readDataFromExcelSheet("Contacts",4,2);
	String leadSource=ex.readDataFromExcelSheet("Contacts", 4,4);
	
	//step 2: Open the browser
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
	 
else {
		System.out.println("Invalid browser");
	}
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	// Step 1: Login
	LoginPage l=new LoginPage(driver);
	l.loginToApp("admin", "admin");
	
	//Step 2: click on contacts link
	HomePage hp=new HomePage(driver);
	hp.clickOnContactLink();
	
	//Step 3: click on create contact image
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContact();
	
	//Step 4: create new contact page
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ccp.createNewContact(lastname, leadSource);
	Thread.sleep(3000);
	driver.quit();
	
}
}
