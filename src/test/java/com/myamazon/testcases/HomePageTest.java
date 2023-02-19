/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.HomePage;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.LoginPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class HomePageTest extends BaseClass {
	LoginPage loginPage;// = new IndexPage();;
	IndexPage indexPage;
	HomePage homePage;

	@Test(groups = "Smoke")
	public void wishlistTest() throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		boolean wishList = homePage.validateMyWishlists();
		Assert.assertTrue(wishList);
	}

	@Test(groups = "Smoke")
	public void orderHistoryTest() throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		boolean orderHistory = homePage.validateOrderHistory();
		Assert.assertTrue(orderHistory);

	}
}
