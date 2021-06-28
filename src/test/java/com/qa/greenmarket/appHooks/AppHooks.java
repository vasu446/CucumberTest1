package com.qa.greenmarket.appHooks;

import com.qa.e.greenmarket.TestBase.TestBase;

import io.cucumber.java.After;

public class AppHooks extends TestBase {
	
	
	@After("@Smoke")
	
	public void afterEachTest()
	{
		System.out.println("Close driver");
		driver.close();
	}

}
