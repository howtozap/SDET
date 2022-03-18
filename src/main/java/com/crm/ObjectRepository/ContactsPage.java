package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	// Step 1: Decelaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookupImg;
	
	// Step 2: Initilalzation
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 3: Utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	// Step 4: Buisness Library
	public void clickOnCreateContact(){
		createContactLookupImg.click();
	}
	
}
