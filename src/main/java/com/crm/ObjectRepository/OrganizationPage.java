package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {
	
	// Step 1: Decelaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	//Step 2: initilazation
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	// Buisness Library
	public void clickOnCreateOrgImg() {
		createOrgLookUpImg.click();	
	}
}
