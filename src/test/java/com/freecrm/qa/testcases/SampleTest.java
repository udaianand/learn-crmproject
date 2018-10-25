package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.LoginPage;

public class SampleTest extends PageBase {

	@BeforeMethod
	public void setUp() {
		intialization();
		LoginPage lp = new LoginPage();
		lp.loginAs("emp2");
	}

	@Test
	public void LoginAsUserTest() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
