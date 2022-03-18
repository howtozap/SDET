package GenericLibrary;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;



public class ListnersImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"-->testscript execution sucessfull");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"--->testscript execution is sucessful - PASS", true);
	
	}

	public void onTestFailure(ITestResult result) {
		
		String path=null;
		String rpath = null;
		
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"--->testscript failed", true);
		
		//Step 1: using screenshot name
		String screenshotName=MethodName+ new JavaUtility().getSystemDate();
		System.out.println(screenshotName);
		
		try {
			//path=new WebDriverUtility().getScreenshot(BaseClass.sDriver, screenshotName);
			EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = Sysďtem.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			path = "./Screenshots/"+screenshotName+new JavaUtility().getSystemDate()+".png";
			File dst = new File(path);
			rpath = dst.getAbsolutePath();
			Files.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, MethodName+"---->failed");
		
		//it will capture the exception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(rpath);
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"---> testscript skipped");
		
		//it will capture the exception and log it in report
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//Execution will start here
	   /*Configure the report*/
	  ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtenReports/Report"+new JavaUtility().getSystemDate()+".html");
	  htmlReport.config().setDocumentTitle("SDET30 Execution report");
	  htmlReport.config().setTheme(Theme.DARK);
	  htmlReport.config().setReportName("Selenium Execution Report");
	  
	  report=new ExtentReports();
	  report.attachReporter(htmlReport);
	  report.setSystemInfo("Base-Browser", "Chrome");
	  report.setSystemInfo("OS", "Windows");
	  report.setSystemInfo("base-url", "http://localhost:8888");
	  report.setSystemInfo("Reporter Name", "Pradeep");
		
	}

	public void onFinish(ITestContext context) {
		// consolidate all the parameter and generate the report
		report.flush();
	}

}
