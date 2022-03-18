package com.crm.PRATICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class praticeRetryAnalyzer {
@Test(retryAnalyzer=GenericLibrary.RetryAnalyzerImplementation.class)
public void retryAnalyzer() {
	System.out.println("this is test 1");
	Assert.fail();
	System.out.println("this is passed");
}
}
