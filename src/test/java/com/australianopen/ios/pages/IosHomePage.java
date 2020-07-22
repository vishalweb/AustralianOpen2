package com.australianopen.ios.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.ios.locators.IosHomePageLocators;
import com.australianopen.ios.locators.IosMorePageLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.ios.IOSDriver;

public class IosHomePage {
	
	private Logger log = LoggerHelper.getLogger(IosHomePage.class);
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	
	public IosHomePage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public IosMorePage clickOnMoreOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosHomePageLocators.IOSMORE_OPTION));
		log.info("Waiting for the element:"+ IosHomePageLocators.IOSMORE_OPTION);
		_driver.findElement(IosHomePageLocators.IOSMORE_OPTION).click();
		return new IosMorePage(_driver,testLog);
	}

}
