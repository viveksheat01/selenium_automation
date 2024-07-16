package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.tests.SearchPageTest;

public class BaseTest {

	DriverFactory df;
	protected Properties prop;
	WebDriver driver;
	protected LoginPage loginpage;
	protected AccountPage accPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		softAssert=new SoftAssert();

		if (browserName != null) {
			prop.setProperty("browser", browserName);

		}

		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
