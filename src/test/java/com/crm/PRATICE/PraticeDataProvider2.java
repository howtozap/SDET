package com.crm.PRATICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PraticeDataProvider2 {
@Test(dataProvider="getFood")
public void sampleDataProvider(String menu, int price) {
	System.out.println(menu+"-->"+price);
}

@DataProvider
public Object[][] getFood(){
	Object[][] obj=new Object[6][2];
	obj[0][0]="Biryani";
	obj[0][1]=90;
	
	obj[1][0]="Tikka";
	obj[1][1]=120;
	
	obj[2][0]="Chilli";
	obj[2][1]=120;
	
	obj[3][0]="Kaju Masala";
	obj[3][1]=190;
	
	obj[4][0]="Dal Tadka";
	obj[4][1]=150;
	
	obj[5][0]="Parotha";
	obj[5][1]=30;
	
	return obj;
}
}
