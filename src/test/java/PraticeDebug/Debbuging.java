package PraticeDebug;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

public class Debbuging {
@Test
public void debug() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp("admin", "ad");
}
}
