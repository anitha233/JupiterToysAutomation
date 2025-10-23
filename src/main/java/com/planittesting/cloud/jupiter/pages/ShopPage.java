package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Represents the Shope Page 
 * 
 * @author anithavalluru
 * 
 */

public class ShopPage extends BasePage{
	
	WebDriver driver;
	
	@FindBy(xpath = "//h4[text()='Stuffed Frog']/following-sibling::p/a")
	private WebElement buyStuffedFrog;
	
	@FindBy(xpath = "//h4[text()='Fluffy Bunny']/following-sibling::p/a")
    private WebElement buyFluffyBunny;

    @FindBy(xpath = "//h4[text()='Valentine Bear']/following-sibling::p/a")
    private WebElement buyValentineBear;
    
    @FindBy(css = "a[href*='#/cart']")
    private WebElement cartMenu;


	
	public ShopPage(WebDriver driver) {
		super(driver);
		
			
	}
	
	public void buyStuffedFrog(int quantity) {
        for (int i = 0; i < quantity; i++) {
            buyStuffedFrog.click();
        }
    }

    public void buyFluffyBunny(int quantity) {
        for (int i = 0; i < quantity; i++) {
            buyFluffyBunny.click();
        }
    }

    public void buyValentineBear(int quantity) {
        for (int i = 0; i < quantity; i++) {
            buyValentineBear.click();
        }
    }

    public void goToCart() {
        cartMenu.click();
    }
	
}
