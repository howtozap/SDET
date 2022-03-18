package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class CampaignPage extends WebDriverUtility {
	//Step 1: Initilization
@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement newCmapaignImg;

//Step 2: Decleration
public CampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//Step 3:Utilization (getter)
public WebElement getNewCmapaignImg() {
	return newCmapaignImg;
}

//Step 4:Buisness Library
public void clickOnNewCampaignLink() {
	newCmapaignImg.click();
}

}
