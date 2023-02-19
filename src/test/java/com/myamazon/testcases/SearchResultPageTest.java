/**
 * 
 */
package com.myamazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myamazon.base.BaseClass;
import com.myamazon.pageobjects.IndexPage;
import com.myamazon.pageobjects.SearchResultPage;

/**
 * @author kanwaljeetsingh
 *
 */
public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@Test(groups ="Smoke" )
	public void productAvailabilityTest() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
		boolean productAvailable = searchResultPage.validateProductAvailability();
		Assert.assertTrue(productAvailable);
	}
	
}
