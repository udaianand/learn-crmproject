package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.util.TestUtil;

public class ContactsPage extends PageBase {

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[2]/td[2]/select")
	protected WebElement do_ActionDropdownList;

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[2]/td[2]/select")
	protected WebElement do_ActionButton;

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[3]/td[1]/input") // header select check box
	protected WebElement selectAll_CheckBox;

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[5]/td[1]/input") // Dynamic element
	protected WebElement select_CheckBox;

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[6]/td[2]/a") // Dynamic element
	protected WebElement name_InTable;

	// Advance Search Input Fields
	@FindBy(name = "cs_name")
	WebElement searchfield_Name;

	@FindBy(name = "cs_company_name")
	WebElement searchfield_CompanyName;

	@FindBy(name = "cs_email")
	WebElement searchfield_Email;

	@FindBy(name = "cs_extended")
	WebElement searchfield_ExtendedFields;

	@FindBy(name = "cs_notes")
	WebElement searchfield_Notes;

	@FindBy(name = "cs_industry")
	WebElement searchfield_Industry;

	@FindBy(name = "cs_tag")
	WebElement searchfield_Tags;

	@FindBy(name = "cs_address")
	WebElement searchfield_Address;

	@FindBy(name = "//*[@id=\"extendedSearchLayer\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[2]/input[1]")
	WebElement saveSearch_CheckBox;

	@FindBy(name = "//*[@id=\"extendedSearchLayer\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[2]/input[2]")
	WebElement search_Button;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchContactByName(String name) throws InterruptedException {
		searchfield_Name.sendKeys(name);
		saveSearch_CheckBox.click();
		saveSearch_CheckBox.click();
		TestUtil.clickOn(driver, search_Button, 30);
	}

	public void enterSearchFields() {
		searchfield_Name.sendKeys("a");
		searchfield_CompanyName.sendKeys("a");
		searchfield_ExtendedFields.sendKeys("a");
		searchfield_Address.sendKeys("a");
		saveSearch_CheckBox.click();

	}

	public void deleteCheckedContacts() {
		Select select = new Select(do_ActionDropdownList);
		select.selectByVisibleText("Delete Checked");
		TestUtil.clickElementByJS(do_ActionButton, driver);

	}

	public void selectAllContacts() {
		selectAll_CheckBox.click();

	}

}
