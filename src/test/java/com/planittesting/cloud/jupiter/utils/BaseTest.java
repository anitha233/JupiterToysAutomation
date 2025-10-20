package com.planittesting.cloud.jupiter.utils;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * 
 * BaseTest handles all browser setup, navigation to base URL, and cleanup.
 * It’s inherited by every test class (avoids duplication).
 * Uses @BeforeMethod and @AfterMethod (TestNG annotations) for setup/teardown.
 * 
 */
public class BaseTest {
	
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl = "http://jupiter.cloud.planittesting.com";
	
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseUrl);
		
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
