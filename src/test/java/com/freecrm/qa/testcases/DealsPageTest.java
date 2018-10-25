package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.LoginPage;

public class DealsPageTest extends PageBase {

	@BeforeMethod
	public void setUp() {
		intialization();
	}

	@Test
	public void validateCreateDeal() {

		LoginPage lp = new LoginPage();
		lp.loginAs("emp2");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
