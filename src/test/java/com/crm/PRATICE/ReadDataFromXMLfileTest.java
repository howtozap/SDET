package com.crm.PRATICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXMLfileTest {
	@Test
	public void readDataFromXML(XmlTest xml) {
		String BROWSER = xml.getParameter("browser");
		String URL = xml.getParameter("url");
		String USERNAME = xml.getParameter("username");
		String PASSWORDS = xml.getParameter("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORDS);
	}

}
