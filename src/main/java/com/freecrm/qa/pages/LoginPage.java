package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.util.TestUtil;
import com.freecrm.qa.util.UserCredentails;

public class LoginPage extends TestBase {

	// 1. Page factory
	@FindBy(name = "username")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[contains(@class,'btn btn-small')]")
	WebElement loginBtn;

	// Initialize
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// TestUtil.clickOn(driver, loginBtn, TestUtil.TIME_OUT);
		TestUtil.clickElementByJS(loginBtn, driver);
		return new HomePage();
	}

	public HomePage loginAs(String userRole) {
		UserCredentails uc = new UserCredentails();
		String[] user = uc.loginAsUserRole(userRole);
		username.sendKeys(user[0]);
		password.sendKeys(user[1]);
		TestUtil.clickElementByJS(loginBtn, driver);
		// TestUtil.clickOn(driver, loginBtn, TestUtil.TIME_OUT);
		return new HomePage();
	}

}
