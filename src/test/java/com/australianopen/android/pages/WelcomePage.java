package com.australianopen.android.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;

public class WelcomePage {
	
	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(WelcomePage.class);
	
	public WelcomePage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}

public WhatsOnPage clickOnSkipAllButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Skip All button in Welcome page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeAndroidLocators.WELCOME_SKIPALL));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+WelcomeAndroidLocators.WELCOME_SKIPALL);
			driver.findElement(WelcomeAndroidLocators.WELCOME_SKIPALL).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +WelcomeAndroidLocators.WELCOME_SKIPALL);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+WelcomeAndroidLocators.WELCOME_SKIPALL);
		}
		return new WhatsOnPage(driver, testLog);
	}
}
