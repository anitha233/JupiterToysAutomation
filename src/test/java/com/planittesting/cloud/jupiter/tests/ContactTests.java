package com.planittesting.cloud.jupiter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.planittesting.cloud.jupiter.pages.ContactPage;
import com.planittesting.cloud.jupiter.pages.HomePage;
import com.planittesting.cloud.jupiter.utils.BaseTest;

public class ContactTests extends BaseTest{
	
	/**
	 * 
	 * Test Case 1: Verify error messages and form validation on the Contact page.
     * 
     * Test Steps:
     * 
     *   Navigate from the Home page to the Contact page.
     *   Click the Submit button without entering any details.
     *   Verify that error messages are displayed for mandatory fields.
     *   Populate all mandatory fields (Forename, Email, and Message).
     *   Click the Submit button again.
     *   Verify that all validation error messages are cleared.
     * 
     *
     * Expected Result: Error messages should appear when fields are empty and disappear
     * after all mandatory fields are correctly filled.
     *
     * Framework: Selenium WebDriver + TestNG (Page Object Model with Page Factory)
     * 
     * Author:Anitha Valluru
     */
	
	
	 @Test(priority=1)
	    public void testcase1_VerifyErrorMessagesAndValidation() {
	        HomePage home = new HomePage(driver);
	        ContactPage contact = home.goToContactPage();
	     
	        //used Explicit wait for specific element
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Submit")));
	        contact.clickSubmit();
	       
	        //Verify that error messages are displayed for mandatory fields.
	        Assert.assertTrue(contact.getErrorMessages().size()>0, "Error messages should appear");
           
	        //Populate all mandatory fields (Forename, Email, and Message).
	       contact.fillMandatoryFields("John", "john@test.com", "Hi there");
	       
	       //Click on Submit Button
	       contact.clickSubmit();
	       
	       //Verify that all validation error messages are cleared.
	       Assert.assertEquals(contact.getErrorMessages().size(), 0,"Errors should be gone");
	    }
	 
	    @Test(priority=2,invocationCount = 5)
	    public void testcase2_VerifySuccessfulSubmission(){
	            HomePage home = new HomePage(driver);
	            ContactPage contact = home.goToContactPage();

	            contact.fillMandatoryFields("Mike", "mike@test.com", "Good day");
	            contact.clickSubmit();
               
	            Assert.assertTrue(contact.isSuccessMessageDisplayed(), "Success message should appear");
	        }
	
	 
	

}
