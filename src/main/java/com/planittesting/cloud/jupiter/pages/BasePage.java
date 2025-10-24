package com.planittesting.cloud.jupiter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Wait object — adjust timeout as needed
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize WebElements in the current page object
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits until an element located by the given locator is visible.
     */
    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until all elements located by the given locator are visible.
     */
    protected void waitForAllElementsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
