package com.freecrm.qa.testDataCleansing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class DeleteData extends PageBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	public void deleteAllContacts() {

	}

	public void deleteAllDeals() {

	}

	public void deleteAllTasks() {

	}

	public void deleteAllData() {

	}

	public void deleteSelectiveContacts() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
