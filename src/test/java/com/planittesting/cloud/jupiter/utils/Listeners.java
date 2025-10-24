package com.planittesting.cloud.jupiter.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.planittesting.cloud.jupiter.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent =  ExtentReporterNG.getReportObject();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}

    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(testInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (driver != null) {
            try {
                String screenshotPath = new BaseTest().getScreenshot(result.getName(), driver);
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("WebDriver is null, skipping screenshot capture.");
        }
    }


    @Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	
}
