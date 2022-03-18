package GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will provide waiting time to load web page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This Method will wait for 20 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will select data from dropdown using index. 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will select list from drop down using visisble text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String VisibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method will select dropdown using value
	 * @param element
	 * @param visibleText
	 */
	public void select(String value, WebElement element) {
		Select sell=new Select(element);
		sell.selectByValue(value);
		
	}
	
	/**
	 * This method will perform mouse action.
	 * @param driver
	 * @param indusType
	 */
	public void mouseHover(WebDriver driver, WebElement indusType) {
		Actions act=new Actions(driver);
		act.moveToElement(indusType).perform();
	}
	
	/**
	 * This method will perform drag and drop
	 * @param driver
	 * @param src
	 * @param dest
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	
	/**
	 * This method will perform double click
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	
	/**
	 * This method will perform double click on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will press Enter
	 * @param driver
	 */
	public void keyPress(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will relese enter key
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch the framebased on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch the frame based on address of the element.
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method will accept alert popup.
	 */
	public void alertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup.
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method switch windows according to partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		// Step 1: use getWindowHandles to capture all window IDs
		Set<String> windows = driver.getWindowHandles();
		
		// Step 2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step 3: Check Whether there is next window or not
		
		while (it.hasNext()) {
			//step 4:capture current window id
			String winId = it.next();
			
			// Step 5: switch to currentwindow and capture title
			 
			 String currentWinTitle= driver.switchTo().window(winId).getTitle();
			if (currentWinTitle.contains(partialWinTitle)) {
				break;
			}
		}
		}
		
	/**
	 * This method will take screenshot
	 * @param driver
	 * @param ScreenShotName
	 * @throws IOException
	 */
		public String getScreenshot(WebDriver driver,String ScreenShotName) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String pathe="./Screenshot/"+ScreenShotName+".png";
			
			File dest = new File(pathe);
			Files.copy(src, dest);
			String path = dest.getAbsolutePath();
			return path;
		}
		
		/**
		 * This method will perform random scroll.
		 */
		public void scrollAction(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
		}
		
		/**
		 * This method will scroll until the specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", element);
			//js.executeScript("argument[0].scrollIntoView()", element);
		}
	}
