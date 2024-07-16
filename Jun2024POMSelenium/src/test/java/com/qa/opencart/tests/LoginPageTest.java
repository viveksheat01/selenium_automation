package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.contants.Appcontants;
import com.qa.opencart.errors.AppErrors;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String actTile = loginpage.getLoginPageTitle();

		Assert.assertEquals(actTile, Appcontants.LOGIN_PAGE_TITLE, AppErrors.TITLE_NOT_FOUND);

	}

	@Test(priority = 2)
	public void loginPageUrlTest() {

		String actUrl = loginpage.getLoginPageUrl();

		Assert.assertTrue(actUrl.contains(Appcontants.LOGIN_PAGE_FRACTION_URL), AppErrors.URL_NOT_FOUND);

	}

	@Test(priority = 3)
	public void forgotpwdLinkExitTest() {
		Assert.assertTrue(loginpage.checkForgotPwdlinkExist(), AppErrors.ELEMENT_NOT_FOUND);

	}

	@Test(priority = 4)
	public void loginTest() {

	accPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertEquals(accPage.getAccPageTitle(), Appcontants.ACCOUNT_PAGE_TITLE,AppErrors.TITLE_NOT_FOUND);
	


	}

}
