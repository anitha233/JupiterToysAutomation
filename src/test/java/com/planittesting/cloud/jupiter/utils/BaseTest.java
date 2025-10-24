package com.planittesting.cloud.jupiter.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * 
 * Represents the Base Test  
 * 
 * @author anithavalluru
 * 
 */
public class BaseTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	String baseUrl = "http://jupiter.cloud.planittesting.com";
	
	
	/*public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName +".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+"//reports//" + testCaseName +".png";
		
	}*/

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }


    @BeforeMethod
	public void setUp() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseUrl);
		
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
