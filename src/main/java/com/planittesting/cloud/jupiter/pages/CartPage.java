package com.planittesting.cloud.jupiter.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * Represents the Cart Page 
 * 
 * @author anithavalluru
 * 
 */
public class CartPage extends BasePage{
	
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "td:nth-child(1)")
   List<WebElement> productNames;

    @FindBy(css = "td:nth-child(2)")
   List<WebElement> productPrices;

    @FindBy(css = "td:nth-child(3) input")
     List<WebElement> productQuantities;

    @FindBy(css = "td:nth-child(4)")
     List<WebElement> productSubtotals;

    @FindBy(css = ".total.ng-binding")
     WebElement totalAmount;

    public CartPage(WebDriver driver) {
		super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

    /**
     * Waits for the cart table to load completely
     */
    public void waitForCartToLoad() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productNames));
    }

    /**
     * Gets the price of a specific product.
     */
    public double getProductPrice(String productName) {
        waitForCartToLoad();
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().trim().equalsIgnoreCase(productName)) {
                return Double.parseDouble(productPrices.get(i).getText().replace("$", "").trim());
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    /**
     * Gets the subtotal of a specific product.
     */
    public double getProductSubtotal(String productName) {
        waitForCartToLoad();
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().trim().equalsIgnoreCase(productName)) {
                return Double.parseDouble(productSubtotals.get(i).getText().replace("$", "").trim());
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    /**
     * Gets the quantity of a specific product.
     */
    public int getProductQuantity(String productName) {
        waitForCartToLoad();
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().trim().equalsIgnoreCase(productName)) {
                return Integer.parseInt(productQuantities.get(i).getAttribute("value"));
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    /**
     * Gets the total amount from the cart.
     */
    public double getTotal() {
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return Double.parseDouble(totalAmount.getText().replace("Total: ", "").replace("$", "").trim());
    }

}
