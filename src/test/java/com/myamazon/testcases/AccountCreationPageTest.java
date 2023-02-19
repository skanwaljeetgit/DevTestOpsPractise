/**
 * 
 */
package com.myamazon.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.AccountCreationPage;
import com.myamazon.pageobjects.HomePage;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.LoginPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class AccountCreationPageTest extends BaseClass{

	LoginPage loginPage;// = new IndexPage();;
	IndexPage indexPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	@Test(groups = "Sanity")
	public void accountCreatePageTest() throws InterruptedException, IOException {
	indexPage = new IndexPage();
	loginPage = indexPage.clickOnSignIn();
	accountCreationPage = loginPage.createNewAccount(prop.getProperty("newemail"));
	
	boolean formHeader = accountCreationPage.validateAccountCreatePage();
	Assert.assertTrue(formHeader);

	}
}