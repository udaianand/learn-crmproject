package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.util.TestUtil;

public class AddContactPage extends PageBase {

	// 1. Page Factory

	/*
	 * Fields Present in New Contact Creation Page
	 */
	// Title
	// First Name
	// Last Name & so on..

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")
	WebElement titleDropdown;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement Save_Btn_NewContact;

	// 2. Initialize page objects using constructor
	public AddContactPage() {
		PageFactory.initElements(driver, this);
	}
	// 3. Actions

	public IndividualContactDetailsPage createNewContact(String title, String firstname, String lastname) {

		Select select = new Select(titleDropdown);
		select.selectByVisibleText(title);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		TestUtil.clickOn(driver, Save_Btn_NewContact, 30);
		return new IndividualContactDetailsPage();

	}

}
