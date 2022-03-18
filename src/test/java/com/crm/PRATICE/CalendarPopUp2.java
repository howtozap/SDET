package com.crm.PRATICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarPopUp2 {
	@Test()
	public void calanderPopup() throws Throwable {
		String date="22";
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
    driver.get("https://www.makemytrip.com/");
    Actions actions=new Actions(driver);
    actions.moveByOffset(10, 10).click().perform();
    driver.findElement(By.xpath("//label[@for='departure']")).click();
    String xpath="//p[text()='28']/ancestor::div[@class='DayPicker-Body']/descendant::div[@aria-label='Thu Apr "+date+" 2022']";
    driver.findElement(By.xpath(xpath)).click();
    Thread.sleep(3000);
    driver.quit();
	}
}
