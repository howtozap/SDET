import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalanderPopUpPratice {
@Test()
public void calanderPopUp() {
	String Date="12";
	String monthAndYear="April 2022";
	//String Arrow="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.makemytrip.com/");
	Actions actions=new Actions(driver);
	actions.moveByOffset(10, 10).click().perform();
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	String dateXpath = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date+"']";
	driver.findElement(By.xpath(dateXpath)).click();
	driver.quit();
}
}
