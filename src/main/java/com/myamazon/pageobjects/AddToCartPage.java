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
public class AddToCartPage extends BaseClass {

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartButton;

	@FindBy(id = "color_15")
	WebElement color;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
	WebElement addToCartMessage;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity) {
		Action.explicitWait(driver, this.quantity, 30);

		//Action.fluentWait(driver, this.quantity, 10);
		Action.type(this.quantity, quantity);
	}

	public void selectSize(String size) {
		//Action.explicitWait(driver, this.size, 30);
		//Action.moveToElement(driver, this.size);
		//Action.fluentWait(driver, this.size, 10);
		Action.selectByVisibleText(size, this.size);
	}

	// extraaa
	public void selectColor(String color) {
		Action.selectByVisibleText(color, this.color);
	}

	public void clickAddToCart() {
		Action.explicitWait(driver, addToCartButton, 30);
//		Action.fluentWait(driver, addToCartButton, 20);
		Action.click(driver, addToCartButton);
	}

	public boolean validateAddToCart() throws InterruptedException {
		Action.explicitWait(driver, addToCartMessage, 30);

		//Action.fluentWait(driver, addToCartMessage, 10);
		return Action.isDisplayed(driver, addToCartMessage);

	}

	public OrderPage clickProceedToCheckout() {
		Action.explicitWait(driver, proceedToCheckoutButton, 30);
//		Action.fluentWait(driver, proceedToCheckoutButton, 10);
		Action.click(driver, proceedToCheckoutButton);
		return new OrderPage();
	}

}
