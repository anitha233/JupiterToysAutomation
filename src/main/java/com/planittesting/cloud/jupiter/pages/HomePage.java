package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Represents the home page of Jupiter Toys.
 * Contains navigation methods to Contact and Shop sections.
 * Uses @FindBy to locate menu links.
 * 
 */

public class HomePage {
	
	WebDriver driver;
	
	
	@FindBy(linkText = "Contact")
	WebElement contactLink;
	
	@FindBy(linkText = "Shop")
	WebElement shopLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToContactPage() {
		contactLink.click();
	}
	
	public void navigateToShopPage() {
		shopLink.click();
	}

}
