/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.AddToCartPage;
import com.myamazon.pageobjects.AddressPage;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.LoginPage;
import com.myamazon.pageobjects.OrderConfirmationPage;
import com.myamazon.pageobjects.OrderPage;
import com.myamazon.pageobjects.OrderSummaryPage;
import com.myamazon.pageobjects.PaymentPage;
import com.myamazon.pageobjects.SearchResultPage;
import com.myamazon.pageobjects.ShippingPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class EndToEndTest extends BaseClass {

	AddressPage addressPage;
	LoginPage loginPage;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@Test(groups = "Regression")
	public void endToEndTest() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		addToCartPage.selectSize(prop.getProperty("size"));
		addToCartPage.clickAddToCart();
		orderPage = addToCartPage.clickProceedToCheckout();
		loginPage = orderPage.clickProceedToCheckout();
		addressPage = loginPage.userLoginToAddress(prop.getProperty("email"), prop.getProperty("password"));
		shippingPage = addressPage.clickProceedToCheckout();
		shippingPage.checkTermsCheckbox();
		paymentPage = shippingPage.clickProceedToCheckout();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickConfirmOrder();
		String actualConfirmOrderMessage = orderConfirmationPage.validateConfirmOrderMessage();
		String expectedConfirmOrderMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actualConfirmOrderMessage, expectedConfirmOrderMessage);
//		
	}

}
