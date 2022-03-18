package com.crm.PRATICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PraticeDataProvider {
	
	@Test(dataProvider="getData")
	public void sampleDataProvider(String name, String model, int price) {
		System.out.println(name+"-->"+model+"-->"+price);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="iPhone";
		obj[0][1]="13 pro max";
		obj[0][2]=139000;
		
		obj[1][0]="Macbook";
		obj[1][1]="Air";
		obj[1][2]=149000;
		
		obj[2][0]="iPad";
		obj[2][1]="pro";
		obj[2][2]=110000;
		
		obj[3][0]="Airpod";
		obj[3][1]="New";
		obj[3][2]=32000;
		
		return obj;
	}
}
