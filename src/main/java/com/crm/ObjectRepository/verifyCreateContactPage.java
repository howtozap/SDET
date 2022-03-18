package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyCreateContactPage {
	// Step1: Deceleration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createContactHeader;

//Step 2:Initilazation
	public verifyCreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 3:Utilization
	public WebElement getCreateContactHeader() {
		return createContactHeader;
	}

//Step 4: Buisness Library
	public String verifyCreatedContact() {
		String header = createContactHeader.getText();
		return header;
	}

}
