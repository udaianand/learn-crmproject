package com.freecrm.qa.thirdparty;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.PageBase;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ImportByRobotClassInJavaAWT extends PageBase {

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

		TestUtil.fileUploadByRobot("D:\\Utility\\TestData\\SampleUploadFile.txt");

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
