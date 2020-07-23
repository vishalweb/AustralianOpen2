package com.australianopen.ios.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.ios.locators.IosPlayerInformationPageLocators;
import com.australianopen.ios.locators.IosPlayersPageLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;

public class IosPlayerInformationPage {
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	
	public IosPlayerInformationPage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void clickOnFavoriteIcon(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosPlayerInformationPageLocators.IOSPLAYER_INFO_FAVORITE_ICON));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosPlayerInformationPageLocators.IOSPLAYER_INFO_FAVORITE_ICON);
		_driver.findElement(IosPlayerInformationPageLocators.IOSPLAYER_INFO_FAVORITE_ICON).click();
	}
	
	public IosPlayersPage clickOnBackButton(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosPlayerInformationPageLocators.IOSPLAYER_INFO_BACK_BTN));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosPlayerInformationPageLocators.IOSPLAYER_INFO_BACK_BTN);
		_driver.findElement(IosPlayerInformationPageLocators.IOSPLAYER_INFO_BACK_BTN).click();
		return new IosPlayersPage(_driver,testLog);
	}	

}
