package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateNewCampaignPage {

	//Step 1: Initialize
@FindBy(name="campaignname")
private WebElement campaignName;

@FindBy(xpath="//input[@class=\"crmButton small save\"]")
private WebElement saveBtn;

//Step 2: Decelaration

public CreateNewCampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

public void saveBtn(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


//Step 3: Uti;ization
public WebElement getLastname() {
	return campaignName;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//Step 4: Buisness Library
public void clickOnCmapaignName(String campName) {
	campaignName.sendKeys(campName);
	saveBtn.click();
}
}
