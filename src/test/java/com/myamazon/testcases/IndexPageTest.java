/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.IndexPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class IndexPageTest extends BaseClass {

	IndexPage indexPage;// = new IndexPage();;

	@Test(groups = "Smoke")
	public void logoTest() throws InterruptedException {
//		Thread.sleep(20000);
		indexPage = new IndexPage();
		boolean logo = indexPage.validateLogo();
		System.out.println(logo);
		Assert.assertTrue(logo);

	}

	@Test(groups = "Smoke")
	public void storeTitleTest() {
		String actualStoreTitle = indexPage.getStoreTitle();
		String expectedStoreTitle = "My Store";
		Assert.assertEquals(actualStoreTitle, expectedStoreTitle);
	}

}
