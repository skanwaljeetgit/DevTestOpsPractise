/**
 * 
 */
package com.myamazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myamazon.actiondriver.Action;
import com.myamazon.base.BaseClass;

/**
 * @author kanwaljeetsingh
 *
 */
public class SearchResultPage extends BaseClass {

//	@FindBy(xpath ="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
//	//"//div[@class='product-image-container']/a[@class='product_img_link']")
//			//"//div[@id='center_column']/ul//div[@class='product-container']//div[@class='product-image-container']/a[@title='Faded Short Sleeve T-shirts']/img[@alt='Faded Short Sleeve T-shirts']")
//	//"//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a/img")
//	WebElement resultTopSellers;
//	

	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement resultTopSellers;

	@FindBy(xpath = "//div[@id='best-sellers_block_right']//ul[@class='block_content products-block']/li[3]/a/img")
	// "//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a/img")
	WebElement resultTopSellersBlouse;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartUnderResult;

	@FindBy(xpath = "//i[@class='icon-eye-open']")
	WebElement eyeIconOnResult;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateProductAvailability() throws InterruptedException {
		return Action.isDisplayed(driver, resultTopSellers);
	}
//
//	public void clickAddToCartFromResult() {
//		Action.fluentWait(driver, addToCartUnderResult, 10);
//		Action.click(driver, addToCartUnderResult);
//	
//	}

	public AddToCartPage clickOnProduct() {
		//Action.fluentWait(driver, resultTopSellers, 20);
		Action.explicitWait(driver, resultTopSellers, 30);
		Action.click(driver, resultTopSellers);
		return new AddToCartPage();
	}

}
