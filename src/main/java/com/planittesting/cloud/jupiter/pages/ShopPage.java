package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Represents Shop Page
 * buyProduct() clicks the "Buy" button for a given product multiple times
 * goToCart() navigates to Cart Page
 */

public class ShopPage {

	WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	public void buyProduct(String productName,int quantity) {
		for(int i=0;i<quantity;i++) {
			driver.findElement(By.xpath("//h4[text()='"+ productName +"']/following-sibling::p/a"));
			
		}
		
	}
	
	public void goToCart() {
		driver.findElement(By.cssSelector("li#nav-cart")).click();
	}
	
	
	
	
	
}
