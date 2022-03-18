package com.crm.PRATICE;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;

public class POMPraticeForHP {
	WebDriver driver;
@Test
public void pomPratice() throws Throwable {
	WebDriverUtility wLib=new WebDriverUtility();
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility fLib=new ExcelFileUtility();
	
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL=pLib.readDataFromPropertyFile("url");
	String USERNAME=pLib.readDataFromPropertyFile("username");
	String PASSWORD=pLib.readDataFromPropertyFile("password");
	
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
	hp.mouseHoverToMore(driver);
	
	hp.clickOnCampaignLink();
}
}
