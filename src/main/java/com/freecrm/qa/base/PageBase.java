package com.freecrm.qa.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.pages.AddContactPage;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.TasksPage;
import com.freecrm.qa.util.TestUtil;

public class PageBase extends TestBase {

	// 1. Page factory [or] Object Repository
	@FindBy(xpath = "//td[contains(text(),'User: UDAIANAND MANICKAM')]") // user is hardcoded.
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	protected WebElement home;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	protected WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	protected WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	// 2. Initializing page Objects

	public PageBase() {
		PageFactory.initElements(driver, this);

	}

	/*
	 * 3.Actions [Majority of the actions are Click Actions, that are used to
	 * navigate from one page to another]
	 */

	public HomePage clickHome() {
		TestUtil.switchToLeftFrame();
		TestUtil.clickOn(driver, home, 30);
		return new HomePage();

	}

	public ContactsPage clickContacts() {
		TestUtil.switchToMainFrame();
		TestUtil.clickOn(driver, contacts, 20);
		return new ContactsPage();

	}

	public DealsPage clickDeals() {
		TestUtil.switchToMainFrame();
		TestUtil.clickOn(driver, deals, 20);
		return new DealsPage();

	}

	public TasksPage clickTasks() {
		TestUtil.switchToMainFrame();
		TestUtil.clickOn(driver, tasks, TestUtil.TIME_OUT);
		return new TasksPage();

	}

	public AddContactPage clickNewContact() {
		TestUtil.switchToMainFrame();
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newContactLink.click();
		return new AddContactPage();
	}

}
