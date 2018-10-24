package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.LoginPage;

public class SampleTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		intialization();
	}

	@Test
	public void LoginAsUserTest() {

		LoginPage lp = new LoginPage();
		lp.loginAs("emp1");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
