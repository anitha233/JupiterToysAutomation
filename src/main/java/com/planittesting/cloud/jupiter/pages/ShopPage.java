package com.planittesting.cloud.jupiter.pages;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopPage extends BasePage {



    @FindBy(css = ".product")
    List<WebElement> products;

    @FindBy(css = "a[href*='#/cart']")
   WebElement cartLink;


    public ShopPage(WebDriver driver) {
        super(driver);


    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Wait until at least one product is visible
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
}

// Get price for a given product name
public double getProductPrice(String productName) {
    for (WebElement product : products) {
        String name = product.findElement(By.cssSelector("h4.product-title")).getText().trim();
        if (name.equalsIgnoreCase(productName.trim())) {
            String priceText = product.findElement(By.cssSelector("span.product-price")).getText().replace("$", "").trim();
            return Double.parseDouble(priceText);
        }
    }
    throw new RuntimeException("Product not found: " + productName);
}

// Buy a product multiple times
public void buyProduct(String productName, int quantity) {
    for (WebElement product : products) {
        String name = product.findElement(By.cssSelector("h4.product-title")).getText().trim();
        if (name.equalsIgnoreCase(productName.trim())) {
            WebElement buyButton = product.findElement(By.xpath(".//a[text()='Buy']"));
            wait.until(ExpectedConditions.elementToBeClickable(buyButton));
            for (int i = 0; i < quantity; i++) {
                buyButton.click();
            }
            return;
        }
    }
    throw new RuntimeException("Product not found: " + productName);
}

// Navigate to Cart page
public CartPage goToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(cartLink)); // ✅ Wait until cart is clickable
    cartLink.click();
    return new CartPage(driver);
}

}
