package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//Create Object of all utilities
	public DataBaseUtility dbLib=new DataBaseUtility();
	public ExcelFileUtility fLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	
	public static WebDriver sDriver; // Used in ITestlistners 
	
	
	@BeforeSuite(groups={"smokeSuite","regression"})
	public void connectToDatabase() {
		//dbLib.connectToDb();
		Reporter.log("db connection succesful", true);
	}
	
	@BeforeClass(groups={"smokeSuite","regression"})
	//@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable   {
		// read data from property file
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL= pLib.readDataFromPropertyFile("url");
		
		//Create run time polymorphism
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		} else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		 //Used in ITestListners
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		sDriver=driver;
		Reporter.log("Browser launch successfull", true);
	}
	
	@BeforeMethod(groups={"smokeSuite","regression"})
	//@BeforeTest
	public void login() throws Throwable {
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups={"smokeSuite","regression"})
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
	}
	
	@AfterClass(groups={"smokeSuite","regression"})
	//@AfterTest
	public void closeBrowser() {
		driver.quit();
		Reporter.log("browser closed successfully",true);
	}
	
	@AfterSuite(groups={"smokeSuite","regression"})
	public void closeDatabase() throws Throwable {
		dbLib.closeDB();
		Reporter.log("Database closed succesfully",true);
	}
}
