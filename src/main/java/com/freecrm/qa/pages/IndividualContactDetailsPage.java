package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.PageBase;

public class IndividualContactDetailsPage extends PageBase {

	// 1. OR

	@FindBy(xpath = "//*[@id=\"vSummary\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement individualContactFullName;

	// 2. Initialize page Objects using the constructor.

	public IndividualContactDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public String readIndividualContactName() {
		String str = individualContactFullName.getText();
		return str;

	}

	public String readContactTableData() {

		String str = individualContactFullName.getText();
		return str;

	}
}
