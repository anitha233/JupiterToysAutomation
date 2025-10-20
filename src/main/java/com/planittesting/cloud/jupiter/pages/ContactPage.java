package com.planittesting.cloud.jupiter.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Represents the Contact Page form
 * 
 * @author anithavalluru
 * 
 */

public class ContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='John']")
	WebElement forename;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "//div[@class='controls']/following::textarea")
	WebElement message;
	
	@FindBy(linkText = "Submit")
	WebElement submitBtn;
	
	@FindBy(css = "span.ng-scope")
	List<WebElement> errorMessages; 
	
	@FindBy(css = ".alert")
	WebElement successMsg;
	
	
	/**
	 * Constructor to create ContactPage object 
	 * @param driver
	 */
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * To click and submit 
	 * 
	 */
	public void clickSubmit() {
		submitBtn.click();
	}
	
	/**
	 * @return List of WebElements. 
	 * 
	 */
	public List<WebElement> getErrorMessages(){
		return errorMessages;
	}
	
	/**
	 * 
	 * @param name
	 * @param mail
	 * @param msg 
	 */
	public void fillMandatoryFields(String name,String mail,String msg) {
		forename.sendKeys(name);
		email.sendKeys(mail);
		message.sendKeys(msg);
	}
	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean isSuccessMessageDisplayed() {
		return successMsg.isDisplayed();
	}

}
