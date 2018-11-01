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
import com.freecrm.qa.util.Xls_Reader;

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

		addContactPage = homePage.clickNewContact();
		individualContactDetailsPage = addContactPage.createNewContact("Dr.", "Joseph", "Fernandez");
		String str = individualContactDetailsPage.readIndividualContactName();
		Assert.assertEquals(str, "Dr. Joseph Fernandez");
	}

	@Test
	public void addMoreNewContacts() {

		Xls_Reader reader = new Xls_Reader(
				"D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\CRMProject\\src\\main\\java\\crm\\freecrm\\qa\\testData\\MasterData.xlsx");
		int rowCount = reader.getRowCount("AddContact");
		System.out.println("ExcelRownCount:::::" + rowCount);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String title = reader.getCellData("AddContact", "title", rowNum);
			System.out.println(title);
			String firstname = reader.getCellData("AddContact", "firstname", rowNum);
			System.out.println(firstname);
			String lastname = reader.getCellData("AddContact", "lastname", rowNum);
			System.out.println(lastname);

			addContactPage = homePage.clickNewContact();
			individualContactDetailsPage = addContactPage.createNewContact(title, firstname, lastname);

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
