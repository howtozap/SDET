package com.crm.PRATICE;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

import GenericLibrary.BaseClass;

@Listeners(GenericLibrary.ListnersImplementationClass.class)

public class PraticeListners extends BaseClass {
	
	
	@Test(retryAnalyzer =GenericLibrary.RetryAnalyzerImplementation.class)
	
	
	public void createOrgWithIndustryDropDownType() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		Assert.fail();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		String orgName=fLib.readDataFromExcelSheet("Org", 4, 2)+jLib.getRandomNumber();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.industryDropDown(orgName, "Engineering");
}
}