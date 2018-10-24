package com.freecrm.qa.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.pages.ContactsPage;

public class PageBase extends TestBase {

	// Page factory or Obj repository
	@FindBy(xpath = "//td[contains(text(),'User: UDAIANAND MANICKAM')]") // user is hardcoded.
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	// // 2. Initializing page Objects
	// public PageBase() {
	// PageFactory.initElements(driver, this);
	// }

	public PageBase() {
		// intialization();
		PageFactory.initElements(driver, this);

	}

	public ContactsPage clickContacts() {
		contacts.click();
		// TestUtil.clickOn(driver, Contacts, 20);
		return new ContactsPage();

	}

}
