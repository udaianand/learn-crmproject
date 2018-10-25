package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.PageBase;

public class SamplePage extends PageBase {

	// 1. Page factory or Object repository

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	// 2. Initialize page objects
	public SamplePage() {
		PageFactory.initElements(driver, this);
	}

	// 3. Actions

	public ContactsPage clickContacts() {
		contacts.click();
		// TestUtil.clickOn(driver, Contacts, 20);
		return new ContactsPage();

	}

	public AddContactPage clickOnNewContactLink() {
		// TestUtil.switchToFrame();
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newContactLink.click();
		return new AddContactPage();
	}

	public DealsPage clickDeals() {
		deals.click();
		return new DealsPage();
	}

}
