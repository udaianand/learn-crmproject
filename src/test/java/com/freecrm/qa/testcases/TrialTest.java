package com.freecrm.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

@Test
public class TrialTest extends PageBase {

	public static WebDriver driver;
	public static Properties prop;

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginAs("emp1");
	}

	@Test
	public void searchContact() throws InterruptedException {

		contactsPage = homePage.clickContacts();
		contactsPage.enterSearchFields();

	}

	public void selectAll() throws InterruptedException {

		contactsPage = homePage.clickContacts();
		contactsPage.searchContactByName("Alexander");
		Thread.sleep(3000);
		contactsPage.selectAllContacts();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
