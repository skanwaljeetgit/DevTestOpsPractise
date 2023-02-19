/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.AddToCartPage;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.OrderPage;
import com.myamazon.pageobjects.SearchResultPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class OrderPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Test(groups = "Regression")
	public void totalPriceTest() throws InterruptedException {
//		indexPage = new IndexPage();
//		searchResultPage = indexPage.searchProduct(productName);
//		addToCartPage = searchResultPage.clickOnProduct();
//		addToCartPage.enterQuantity(qty);
//		addToCartPage.selectSize(size);
//		addToCartPage.clickAddToCart();
//		orderPage = addToCartPage.clickProceedToCheckout();
//		double unitPrice = orderPage.getUnitPrice();
//		double totalPrice = orderPage.getTotalPrice();
//		double expectedTotalPrice = (unitPrice*2) + 2;
//		Assert.assertEquals(totalPrice, expectedTotalPrice);
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct(prop.getProperty("productName"));
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		addToCartPage.selectSize(prop.getProperty("size"));
		addToCartPage.clickAddToCart();
		orderPage=addToCartPage.clickProceedToCheckout();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(prop.getProperty("qty"))))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

}
