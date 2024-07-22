package com.qa.opencart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.contants.Appcontants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.Timeutil;import dev.failsafe.Timeout;

public class LoginPage {
	private WebDriver driver;

	private ElementUtil eleUtil;

	// 1. page object : By locator

	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");


	// 2. public const.... of the page

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// public page action

	public String getLoginPageTitle() {

		String title = eleUtil.waitForTitleToBe(Appcontants.LOGIN_PAGE_TITLE, Timeutil.DEFAULT_TIME);

		System.out.println("login page Title========= " + title);
		return title;
	}

	public String getLoginPageUrl() {

		String getUrl = eleUtil.waitForURLToBe(Appcontants.LOGIN_PAGE_FRACTION_URL, Timeutil.DEFAULT_TIME);

		System.out.println("login page URL" + getUrl);
		return getUrl;
	}

	public boolean checkForgotPwdlinkExist() {

		return eleUtil.doIsDisplayed(forgotPwdLink);

	}

	public AccountPage doLogin(String username, String pwd) {

		eleUtil.doSendKeys(emailID, username, Timeutil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new AccountPage(driver);

	}

	public RegisterationPage navigateToRegisterPage()
	{
		eleUtil.doClick(registerLink,Timeutil.DEFAULT_TIME);
		return new RegisterationPage(driver);
	}
	
	
	
	
}
