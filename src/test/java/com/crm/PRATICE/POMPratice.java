package com.crm.PRATICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPratice {
	
	@Test
	public void pomPratice() {
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		LoginPage l=new LoginPage(driver);
		l.loginToApp("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
	}
	
}
