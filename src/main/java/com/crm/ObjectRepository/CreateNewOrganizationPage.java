package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	// Step 1:Decelaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name= "industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	//Step 2: Initilazation
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: Utlization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	// Buisness Library
	/**
	 * This method will create organization with org name.
	 * @param orgName
	 */
	public void createNewOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with indusrty type drop down.
	 * @param orgName
	 * @param valueOfSelectDropDown
	 */
	public void industryDropDown(String orgName,String valueOfSelectDropDown) {
		OrgNameEdt.sendKeys(orgName);
		select(industryDropDown, valueOfSelectDropDown);
		saveBtn.click();
	}
	
	public void typeDropDown(String orgName, String valueOfSelectDropDown) {
		OrgNameEdt.sendKeys(orgName);
		select(typeDropDown, valueOfSelectDropDown);
	}
}
