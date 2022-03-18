package com.crm.PRATICE;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewCampaignPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.CreateNewOppurtunities;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OppurtinitiesPage;
import com.crm.ObjectRepository.verifyCreateContactPage;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;

public class POMPraticeOrganization {

	WebDriver driver;
	@Test
	public void organization() throws IOException, InterruptedException {
	
	WebDriverUtility wLib=new WebDriverUtility();
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility fLib=new ExcelFileUtility();
	
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL=pLib.readDataFromPropertyFile("url");
	String USERNAME=pLib.readDataFromPropertyFile("username");
	String PASSWORD=pLib.readDataFromPropertyFile("password");
	String lastName=fLib.readDataFromExcelSheet("Contacts", 5, 2);
	String campName=fLib.readDataFromExcelSheet("Campaigns", 2, 1);
	String oppName=fLib.readDataFromExcelSheet("Oppurtunities", 1, 0);
	String partialWinTitleForContacts=fLib.readDataFromExcelSheet("Oppurtunities", 1, 1);
	String createContactPartialHeader=fLib.readDataFromExcelSheet("Contacts", 2, 2);
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	} else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("Incorrect browser");
	}
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnContactLink();
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContact();
	
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ccp.createNewContact(lastName);
	
	verifyCreateContactPage vcc=new verifyCreateContactPage(driver);	
	String header = vcc.verifyCreatedContact();
	if (header.contains(createContactPartialHeader)) {
		System.out.println(header);
		System.out.println(" created succesfully");
	} else {
		System.out.println(header);
		System.out.println(" not created succesfully");
	}
	
	hp.mouseHoverToMore(driver);
	hp.clickOnCampaignLink();
	CampaignPage cmp=new CampaignPage(driver);
	cmp.clickOnNewCampaignLink();
	
	CreateNewCampaignPage cnc=new CreateNewCampaignPage(driver);
	cnc.clickOnCmapaignName(campName);
	hp.clickOnOppurtunities();
	
	OppurtinitiesPage op=new OppurtinitiesPage(driver);
	op.clickOnAddOppurtunities();
	
	CreateNewOppurtunities cno=new CreateNewOppurtunities(driver);
	cno.oppurtunityName(oppName);
	String title=driver.getTitle();
	cno.selectContactsInRelatedToDropDown();
	cno.clickOnAddRelatedToImg(driver, partialWinTitleForContacts);
	
	driver.findElement(By.xpath("//a[contains(@onclick,'vtlib_setvalue_from_popup')]")).click();
	wLib.switchToWindow(driver, title);
	cno.clickOnAddCampaignSourceImg(driver);
	driver.findElement(By.xpath("//a[contains(@onclick,\"CHANDRAYAAN\")]")).click();
	wLib.switchToWindow(driver, title);
	cno.clickOnSaveBtn();
	hp.signOutOfApp(driver);
	driver.quit();
	}
}

