package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//Step 1: Decelaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']//following-sibling::img")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	//Step 2:Initialization
	
	public  CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 3: Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Step 4: Buisness Library
	public void createNewContact(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void createNewContact(String lastname, String leadsource) {
		lastNameEdt.sendKeys(lastname);
		select(leadSourceDropDown, leadsource);
		saveBtn.click();
	}

	public void createNewContact(WebDriver driver,String lastname, String orgName) {
		lastNameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}

}
