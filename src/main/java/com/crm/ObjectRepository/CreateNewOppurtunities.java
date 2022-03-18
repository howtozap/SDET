package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class CreateNewOppurtunities extends WebDriverUtility {
	//Step 1: Decleration
@FindBy(name="potentialname")
private WebElement oppurtunityName;

@FindBy(id="related_to_type")
private WebElement relatedToDropDown;

@FindBy(xpath="//input[@name='related_to_display']/../child::img")
private WebElement addRelatedToImg;

@FindBy(id="sales_stage")
private WebElement salesStagesDropDown;

@FindBy(xpath="//input[@name='campaignname']/..//child::img")
private WebElement addCampaignSourceImg;

@FindBy(name="leadsource")
private WebElement leadSourceDropDown;

@FindBy(xpath="//input[@type='submit']")
private WebElement saveBtn;

//Step 2: Initilazation
public CreateNewOppurtunities(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//Step 3: Utilization
public WebElement getOppurtunityName() {
	return oppurtunityName;
}

public WebElement getRelatedToDropDown() {
	return relatedToDropDown;
}

public WebElement getAddRelatedToImg() {
	return addRelatedToImg;
}

public WebElement getSalesStagesDropDown() {
	return salesStagesDropDown;
}

public WebElement getAddCampaignSourceImg() {
	return addCampaignSourceImg;
}

public WebElement getLeadSourceDropDown() {
	return leadSourceDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//Step 4: Buisness Library
public void oppurtunityName(String oppurName) {
	oppurtunityName.sendKeys(oppurName);
}
public void selectContactsInRelatedToDropDown() {
	select("Contacts", relatedToDropDown);
}

public void clickOnAddRelatedToImg(WebDriver driver, String partialWinTitle) {
	addRelatedToImg.click();
	switchToWindow(driver, partialWinTitle);
}

public void selectEmployeeFromLeadSourceDropDown() {
	select(leadSourceDropDown, "Employee");
}

public void clickOnAddCampaignSourceImg(WebDriver driver) {
	addCampaignSourceImg.click();
	switchToWindow(driver, "Campaigns");
}

public void clickOnSaveBtn() {
	saveBtn.click();
}
}


