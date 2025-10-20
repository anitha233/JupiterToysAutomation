package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 *  Represents the Cart Page
 *  Retrieves price, subtotal, and total values
 *  Converts price strings (like $10.99) to numeric values for validation
 *  Used to verify that total = sum of all subtotals
 */
public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public double getProductPrice(String productName) {
        String priceText = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)")).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }
	
	public double getProductSubtotal(String productName) {
        String subtotalText = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(4)")).getText();
        return Double.parseDouble(subtotalText.replace("$", ""));
    }
	
	

}
