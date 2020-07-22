package com.australianopen.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.android.locators.WhatsOnPageAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class WhatsOnPage {
	
	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(WhatsOnPage.class);
	
	public WhatsOnPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public MorePage clickOnMoreButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Skip All button in Welcome page");
			log.info("Clicking on Skip All button in Welcome page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(WhatsOnPageAndroidLocators.WHATSON_MORE));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+WhatsOnPageAndroidLocators.WHATSON_MORE);
			log.info("Waiting for the element:"+WhatsOnPageAndroidLocators.WHATSON_MORE);
			driver.findElement(WhatsOnPageAndroidLocators.WHATSON_MORE).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +WhatsOnPageAndroidLocators.WHATSON_MORE);
			log.info("Element not found:" +WhatsOnPageAndroidLocators.WHATSON_MORE);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+WhatsOnPageAndroidLocators.WHATSON_MORE);
			log.info("Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+WhatsOnPageAndroidLocators.WHATSON_MORE);
		}
		return new MorePage(driver, testLog);
	}

}
