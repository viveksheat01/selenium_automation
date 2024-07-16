package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppErrors;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][] getProductsData() {
		return new Object[][] { { "macbook", "MacBook Pro" }, { "imac", "iMac" },
				{ "samsung", "Samsung SyncMaster 941BW" }, { "canon", "Canon EOS 5D" },

		};

	}

	@Test(dataProvider = "getProductsData")
	public void productHeaderTest(String seachKey, String productName) {

		searchResultsPage = accPage.doSearch(seachKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName, AppErrors.HEADER_NOT_FOUND);

	}

	@DataProvider
	public Object[][] getProductsImagesdata() {
		return new Object[][] { { "macbook", "MacBook Pro", 4 }, { "imac", "iMac", 3 },
				{ "samsung", "Samsung SyncMaster 941BW", 1 }, { "samsung", "Samsung Galaxy Tab 10.1", 7 },

				{ "canon", "Canon EOS 5D", 3 },

		};

	}

	@Test(dataProvider = "getProductsImagesdata")

		public void productImagesCountTest(String searchKey, String productName, String imagesCount) {
			searchResultsPage = accPage.doSearch(searchKey);
			productInfoPage = searchResultsPage.selectProduct(productName);
			Assert.assertEquals(productInfoPage.getProductImagesCount(), imagesCount, AppErrors.IMAGES_NOT_MISMATCHED);

	}

	// test with multiple assertion used soft assert
	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> productInfoMap = productInfoPage.getProductInfoMap();
		System.out.println("======product information========");
		System.out.println(productInfoMap);

		
		  softAssert.assertEquals(productInfoMap.get("productname"), "MacBook Pro",
		  AppErrors.HEADER_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("Brand"), "Apple",
		  AppErrors.BRAND_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18",
		  AppErrors.CODE_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("Reward Points"), "800",
		  AppErrors.REWARD_POINTS_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock",
		  AppErrors.AVAILABILITY_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("productprice"), "$2,000.00",
		  AppErrors.PRICE_NOT_FOUND);
		  softAssert.assertEquals(productInfoMap.get("exTaxPrice"), "$2,000.00",
		  AppErrors.EX_TAX_PRICE_NOT_FOUND);
		  
		 softAssert.assertAll();
		
	}

}
