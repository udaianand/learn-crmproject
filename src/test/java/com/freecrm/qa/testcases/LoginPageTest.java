package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		intialization();
	}

	@Test(priority = 1)
	public void LoginAsUserTest() {

		loginPage = new LoginPage();
		homePage = loginPage.loginAs("emp3");

		String Title = homePage.validateHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO");

	}

	@Test(priority = 2)
	public void loginTest() {

		loginPage = new LoginPage();
		try {
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Title = homePage.validateHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
