 package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.Timeutil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By searchResult = By.cssSelector("div.product-thumb");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public int getSearchResultsCount() {
		List<WebElement> resultList = eleUtil.waitForPresenceOfElemenetsLocated(searchResult,
				Timeutil.DEFAULT_MEDIUM_TIME);

		int resultCount = resultList.size();
		System.out.println("product search results count =====" + resultCount);
		return resultCount;

	}

	public ProductInfoPage selectProduct(String productName) {
		System.out.println("product name ===" + productName);

		eleUtil.doClick(By.linkText(productName), Timeutil.DEFAULT_TIME);
		
		return new ProductInfoPage(driver);

	}

}
