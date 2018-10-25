package com.freecrm.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITLY_WAIT = 20;
	public static int TIME_OUT = 40; // as of now, used to pass as parameter in clickOn()
	// public static String TESTDATA_SHEET_PATH =
	// "D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\CRMProject\\src\\main\\java\\com\\freecrm\\qa\\testdata\\CRM_Contacts.xlsx";

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void switchToFrame() {

	}

}
