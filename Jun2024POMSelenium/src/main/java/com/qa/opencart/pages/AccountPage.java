package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.contants.Appcontants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.Timeutil;

public class AccountPage {

	private WebDriver driver;

	private ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By logoutLink = By.linkText("Logout");
	private By headrs = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	public String getAccPageTitle() {

		String title = eleUtil.waitForTitleToBe(Appcontants.ACCOUNT_PAGE_TITLE, Timeutil.DEFAULT_TIME);

		System.out.println("Account page Title==== " + title);
		return title;

	}

	public String getAccPageUrl() {

		String getUrl = eleUtil.waitForURLToBe(Appcontants.ACC_PAGE_FRACTION_URL, Timeutil.DEFAULT_TIME);

		System.out.println("account page URL" + getUrl);
		return getUrl;

	}

	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);

	}

	public List<String> getAccPageHearders() {

		List<WebElement> headerList = eleUtil.waitForVisibilityOfElemenetsLocated(headrs, Timeutil.DEFAULT_MEDIUM_TIME);
		List<String> headerValList = new ArrayList<String>();
		for (WebElement e : headerList) {
			String text = e.getText();
			headerValList.add(text);
		}

		return headerValList;
	}

	public boolean isSerachExist() {
		
		return eleUtil.doIsDisplayed(search);
	}

	public SearchResultsPage doSearch(String searchKey) {
		System.out.println("searching.......... :" + searchKey);

		if (isSerachExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchResultsPage(driver);

		} else {
			System.out.println(" search field is not present on the page ");

			return null;
		}
	}

}
