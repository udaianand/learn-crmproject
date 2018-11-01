package com.freecrm.qa.thirdparty;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ImportConceptWithAutoIT extends PageBase {

	@BeforeMethod
	public void setUp() {
		intialization();
	}

	@Test
	public void importData() throws Exception {

		LoginPage lp = new LoginPage();
		lp.loginAs("emp2");

		// TestUtil.scrollPageDown(driver);
		// TestUtil.switchToLeftFrame();
		TestUtil.switchToMainFrame();

		driver.findElement(By.linkText("Import")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'Import')]")).click();
		// This will click on Upload button
		driver.findElement(By.name("import_file")).click();

		// This will invoke AutoIT script here give the path of the script
		// and this will throw IO exception so u can use throw or try catch
		// In my case I am using throws

		Runtime.getRuntime().exec("D:\\Aanand\\AutoITScript\\ImportData.exe");

		// Once you will run this program AutoIt script will be invoked and respective
		// file will be attached.

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
