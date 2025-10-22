package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * Represents the Home Page
 *
 * @author anithavalluru
 *
 */

public class HomePage extends BasePage{

    @FindBy(linkText = "Contact")
    WebElement contactLink;

    @FindBy(linkText = "Shop")
    WebElement shopLink;

    @FindBy(linkText = "Cart")
    WebElement cartLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ContactPage goToContactPage() {
        contactLink.click();
        return new ContactPage(driver);
    }

    public ShopPage goToShopPage() {
        shopLink.click();
        return new ShopPage(driver);
    }

    public CartPage goToCartPage() {
        cartLink.click();
        return new CartPage(driver);
    }


}
