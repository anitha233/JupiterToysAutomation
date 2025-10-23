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
    private List<WebElement> productNames;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//tr/td[3]/input")
    private List<WebElement> productQuantities;

    @FindBy(xpath = "//tr/td[4]")
    private List<WebElement> productSubtotals;

    @FindBy(xpath = "//strong[contains(text(),'Total')]")
    private WebElement totalPrice;
	
	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	public double getPrice(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                return Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
            }
        }
        return 0.0;
    }

    public double getSubtotal(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                return Double.parseDouble(productSubtotals.get(i).getText().replace("$", ""));
            }
        }
        return 0.0;
    }

    public int getQuantity(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                return Integer.parseInt(productQuantities.get(i).getAttribute("value"));
            }
        }
        return 0;
    }

    public double getTotal() {
        String totalText = totalPrice.getText().replace("Total: ", "").replace("$", "");
        return Double.parseDouble(totalText);
    }
	
	
	

}
