package com.australianopen.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.MorePageAndroidLocators;
import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.android.locators.WhatsOnPageAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MorePage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MorePage.class);
	
	public MorePage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public boolean verifyMorePageTitleVisibility() {
		boolean status=false;
		try {
		testLog.log(LogStatus.INFO,"Verifying More Title in More Page");	
		log.info("Verifying More Title in More Page");	
		WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
		status=wait.until(ExpectedConditions.visibilityOfElementLocated(MorePageAndroidLocators.MORE_MORETITLE)).isDisplayed();
	}catch(NoSuchElementException e) {
		testLog.log(LogStatus.INFO,"Element not found:" +MorePageAndroidLocators.MORE_MORETITLE);
		log.info("Element not found:" +MorePageAndroidLocators.MORE_MORETITLE);
	}catch(TimeoutException e) {
		testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_MORETITLE);
		log.info("Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_MORETITLE);
	}
		return status;
	}


	
	public ShopPage clickOnShopOption() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Shop in More page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(MorePageAndroidLocators.MORE_SHOP));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+MorePageAndroidLocators.MORE_SHOP);
			driver.findElement(MorePageAndroidLocators.MORE_SHOP).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +MorePageAndroidLocators.MORE_SHOP);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_SHOP);
		}
		return new ShopPage(driver, testLog);
	}
	
}
