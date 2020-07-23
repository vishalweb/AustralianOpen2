package com.australianopen.ios.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.australianopen.ios.locators.IosMorePageLocators;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;

public class IosMorePage {
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=60;
	
	public IosMorePage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void validateMorePage(){
		boolean status=_driver.findElement(IosMorePageLocators.IOSMORE_TEXT).isDisplayed();
		try{
			if(status){
				testLog.log(LogStatus.INFO,"More Page is displayed");
			}
		}catch(NoSuchElementException e){
			testLog.log(LogStatus.INFO,"More page is not displayed");
		}
	}
	
	public IosConditionOfUsePage clickOnConditionOfUseOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_CONDITIONOFUSE));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosMorePageLocators.IOSMORE_CONDITIONOFUSE);
		_driver.findElement(IosMorePageLocators.IOSMORE_CONDITIONOFUSE).click();
		return new IosConditionOfUsePage(_driver,testLog);
	}
	
	public IosPlayersPage clickOnPlayersOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_PLAYERS));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosMorePageLocators.IOSMORE_PLAYERS);
		_driver.findElement(IosMorePageLocators.IOSMORE_PLAYERS).click();
		return new IosPlayersPage(_driver,testLog);
	}
	
	public IosShopPage clickOnShopOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_SHOP));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosMorePageLocators.IOSMORE_SHOP);
		_driver.findElement(IosMorePageLocators.IOSMORE_SHOP).click();
		return new IosShopPage(_driver, testLog);
	}

}
