/**
 * 
 */
package com.myamazon.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
public class LoginPageTest extends BaseClass {

	LoginPage loginPage;// = new IndexPage();;
	IndexPage indexPage;
	HomePage homePage;

	@Test(groups = {"Smoke", "Sanity"})
	public void loginTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		
		String actualURL = homePage.getCurrentUrl();
		String expectedURL = prop.getProperty("expectedUrl");
		AssertJUnit.assertEquals(actualURL, expectedURL);
	}
}
