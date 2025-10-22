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

public class ContactPage extends BasePage{

    @FindBy(id = "forename") WebElement forename;
    @FindBy(id = "email") WebElement email;
    @FindBy(id = "message") WebElement message;
    @FindBy(linkText = "Submit") WebElement submitButton;

    @FindBy(css = ".help-inline")List<WebElement> errorMessages;
    @FindBy(css = ".alert-success") WebElement successAlert;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit() {

        submitButton.click();
    }

    public void fillMandatoryFields(String name, String mail, String msg) {
        forename.sendKeys(name);
        email.sendKeys(mail);
        message.sendKeys(msg);
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public boolean isSuccessMessageDisplayed() {
        return successAlert.isDisplayed();
    }
}
