package com.crm.PRATICE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePratice {

		@Test
		public void propertyFile() throws IOException {
			// step 1: read the file
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			
			//step 2: Create Object of Properties
			Properties pObj=new Properties();
			pObj.load(fis);
			
			//step 3:read the data
			String USERNAME = pObj.getProperty("username");
			String BROWSER = pObj.getProperty("browser");
			
			//verification
			System.out.println(USERNAME);
			System.out.println(BROWSER);
		}



}
