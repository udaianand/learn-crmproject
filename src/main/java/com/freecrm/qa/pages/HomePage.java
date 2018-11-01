package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.util.TestUtil;

public class HomePage extends PageBase {

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

	// 2. Initializing page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// 3. Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserNameLabel() {
		TestUtil.switchToMainFrame();
		return userNameLabel.isDisplayed();
	}

}
