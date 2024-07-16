package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.contants.Appcontants;
import com.qa.opencart.errors.AppErrors;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {

		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), Appcontants.ACCOUNT_PAGE_TITLE, AppErrors.TITLE_NOT_FOUND);

	}

	@Test
	public void accPageUrlTest() {
		Assert.assertTrue(accPage.getAccPageUrl().contains(Appcontants.ACC_PAGE_FRACTION_URL), AppErrors.URL_NOT_FOUND);

	}

	@Test
	public void accPageHeaderTest() {
		List<String> accpageHeadersList = accPage.getAccPageHearders();
		Assert.assertEquals(accpageHeadersList, Appcontants.ACC_PAGE_HEADERS_LIST, AppErrors.LIST_IS_NOT_MATCHED);
	}

	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "macbook", 3 }, { "imac", 1 }, { "samsung", 2 }, { "Airtel", 0 }

		};

	}

	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, int resultsCount) {
		searchResultsPage = accPage.doSearch(searchKey);
		Assert.assertEquals(searchResultsPage.getSearchResultsCount(), resultsCount, AppErrors.RESULTS_LIST_COUNT_MISMACTED);

	}

}
