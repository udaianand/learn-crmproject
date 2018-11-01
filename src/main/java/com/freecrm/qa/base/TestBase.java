package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.qa.util.TestUtil;

public class TestBase {

	// Declare & Initialize variables
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip;

			ip = new FileInputStream(
					"D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\CRMProject\\src\\main\\java\\com\\freecrm\\qa\\config\\config.properties");

			prop.load(ip);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void intialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Aanand\\Driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Aanand\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
