package com.australianopen.ios.pages;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.ios.locators.IosHomePageLocators;
import com.australianopen.ios.locators.IosMorePageLocators;
import com.australianopen.locators.IosLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.ios.IOSDriver;

public class IosMorePage {
	
	private Logger log = LoggerHelper.getLogger(IosMorePage.class);
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
				log.info("More Page is displayed");
			}
		}catch(NoSuchElementException e){
			log.info("More page is not displayed");
		}
	}
	
	public IosConditionOfUsePage clickOnConditionOfUseOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_CONDITIONOFUSE));
		log.info("Waiting for the element:"+ IosMorePageLocators.IOSMORE_CONDITIONOFUSE);
		_driver.findElement(IosMorePageLocators.IOSMORE_CONDITIONOFUSE).click();
		return new IosConditionOfUsePage(_driver,testLog);
	}
	
	public IosPlayersPage clickOnPlayersOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_PLAYERS));
		log.info("Waiting for the element:"+ IosMorePageLocators.IOSMORE_PLAYERS);
		_driver.findElement(IosMorePageLocators.IOSMORE_PLAYERS).click();
		return new IosPlayersPage(_driver,testLog);
	}
	
	public IosShopPage clickOnShopOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosMorePageLocators.IOSMORE_SHOP));
		log.info("Waiting for the element:"+ IosMorePageLocators.IOSMORE_SHOP);
		_driver.findElement(IosMorePageLocators.IOSMORE_SHOP).click();
		return new IosShopPage(_driver, testLog);
	}

}
