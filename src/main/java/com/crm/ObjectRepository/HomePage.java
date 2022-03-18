package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	// Step 1: Decelaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppurtunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="More")
	private WebElement moreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	// Step 2: initilazation
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3 : generate getters
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppurtunitiesLnk() {
		return oppurtunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//buisness Library
	
	
	public void clickOnOrgLnk() {
		organizationLnk.click();
	}
	
	
	public void clickOnContactLink() {
		contactsLnk.click();
		
	}
	
	public void signOutOfApp(WebDriver driver) {
		mouseHover(driver, administratorImg);
		signOutLnk.click();
	}
	
	public void mouseHoverToMore(WebDriver driver) {
			mouseHover(driver, moreLnk );
		}
		
	public void clickOnCampaignLink() {
			campaignsLnk.click();
		}
	
	public void clickOnOppurtunities() {
		oppurtunitiesLnk.click();
		}
}
