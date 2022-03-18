package com.crm.PRATICE;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

import GenericLibrary.BaseClass;

public class PraticeBaseClassOrganization extends BaseClass {
	
	@Test
	public void createOrg() throws IOException
	{
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		String orgName = fLib.readDataFromExcelSheet("Org", 4, 2)+jLib.getRandomNumber();
		
		cop.createNewOrg(orgName);
	}
}
