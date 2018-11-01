package com.freecrm.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.qa.base.TestBase;

public class TestUtil extends TestBase {

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

	public static void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void switchToLeftFrame() {
		driver.switchTo().frame("leftpanel");
	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void fileUploadByRobot(String file) throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringSelection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
