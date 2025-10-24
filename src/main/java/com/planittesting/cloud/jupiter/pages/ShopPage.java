package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

/**
 * 
 * Represents the Shope Page 
 * 
 * @author anithavalluru
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

    public class ShopPage extends BasePage{


        // ✅ Locators for products and Add buttons
        @FindBy(xpath = "//h4[@class='product-title ng-binding']")
        List<WebElement> productNames;

        @FindBy(xpath = "//span[@class='product-price ng-binding']")
        List<WebElement> productPrices;

        @FindBy(xpath = "//a[text()='Buy']")
        List<WebElement> buyButtons;

        @FindBy(id = "nav-cart")
        private WebElement cartLink;

        public ShopPage(WebDriver driver) {
            super(driver);
        }

        // ✅ Buy a given quantity of product by name
        public void buyProduct(String productName, int quantity) {
            for (int i = 0; i < productNames.size(); i++) {
                if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                    for (int j = 0; j < quantity; j++) {
                        buyButtons.get(i).click();
                    }
                    break;
                }
            }
        }

        // ✅ Get price from Shop page
        public double getProductPrice(String productName) {
            for (int i = 0; i < productNames.size(); i++) {
                if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                    String priceText = productPrices.get(i).getText().replace("$", "").trim();
                    return Double.parseDouble(priceText);
                }
            }
            throw new RuntimeException("Product not found: " + productName);
        }

        // ✅ Navigate to Cart page
        public CartPage goToCart() {
            cartLink.click();
            return new CartPage(driver);
        }
    }



