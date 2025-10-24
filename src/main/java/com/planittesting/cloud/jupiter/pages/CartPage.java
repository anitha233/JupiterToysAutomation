package com.planittesting.cloud.jupiter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * Represents the Cart Page 
 * 
 * @author anithavalluru
 * 
 */
public class CartPage extends BasePage{
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//tr/td[1]")
   List<WebElement> productNames;

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//tr/td[3]/input")
    List<WebElement> productQuantities;

    @FindBy(xpath = "//tr/td[4]")
    List<WebElement> productSubtotals;

    @FindBy(xpath = "//strong[contains(text(),'Total')]")
    WebElement totalAmount;
	
	public CartPage(WebDriver driver) {
		super(driver);
		
	}


    public double getProductPrice(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                String priceText = productPrices.get(i).getText().replace("$", "").trim();
                return Double.parseDouble(priceText);
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public int getProductQuantity(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                return Integer.parseInt(productQuantities.get(i).getAttribute("value"));
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public double getProductSubtotal(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                String subtotalText = productSubtotals.get(i).getText().replace("$", "").trim();
                return Double.parseDouble(subtotalText);
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public double getTotal() {
        String totalText = totalAmount.getText().replace("$", "").trim();
        return Double.parseDouble(totalText);
    }
	
	
	

}
