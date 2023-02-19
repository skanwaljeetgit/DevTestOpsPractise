/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.AddToCartPage;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.SearchResultPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Test(groups = {"Regression", "Sanity"})
	public void addToCartTest() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prop.getProperty("password"));
		//Thread.sleep(20000);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		addToCartPage.selectSize(prop.getProperty("size"));
		//Thread.sleep(20000);
		addToCartPage.clickAddToCart();
		boolean addedToCart = addToCartPage.validateAddToCart();
		Assert.assertTrue(addedToCart);
	}

}
