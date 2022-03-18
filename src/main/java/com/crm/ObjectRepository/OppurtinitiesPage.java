package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

/**
 * @author prade
 *
 */
public class OppurtinitiesPage extends WebDriverUtility {
	
	// Step 1: Decleration
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement addOpportunitiesImg;

	
	
	// Step 2: initialization
	public OppurtinitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Step 3: Utilization
	public WebElement getAddOpportunitiesImg() {
		return addOpportunitiesImg;
	}
	
	//Step 4: Buisness Library
	
	public void clickOnAddOppurtunities() {
		addOpportunitiesImg.click();
	}
	
	
}
