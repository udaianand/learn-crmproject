package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.AddContactPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.IndividualContactDetailsPage;
import com.freecrm.qa.pages.LoginPage;

public class AddContactPageTest extends PageBase {

	LoginPage loginPage;
	HomePage homePage;
	AddContactPage addContactPage;
	IndividualContactDetailsPage individualContactDetailsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		loginPage = new LoginPage(); // Here the (object) LoginPage instance is created, else NPE.
		/*
		 * homePage Object is NOT created here, because login() method returns a new
		 * home page object.
		 */
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void validateCreateNewContact() {

		addContactPage = homePage.addNewContact();
		individualContactDetailsPage = addContactPage.createNewContact("Dr.", "Joseph", "Fernandez");

		String str = individualContactDetailsPage.readIndividualContactName();
		Assert.assertEquals(str, "Dr. Joseph Fernandez");
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
