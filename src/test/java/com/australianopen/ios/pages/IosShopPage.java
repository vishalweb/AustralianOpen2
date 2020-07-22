package com.australianopen.ios.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.tests.BaseTestSuite;
import com.australianopen.ios.locators.IosFavoritePageLocators;
import com.australianopen.ios.locators.IosShopPageLocators;
import com.australianopen.ios.tests.IosBaseTestSuite;
import com.australianopen.utils.ConfigFileReader;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.ios.IOSDriver;

public class IosShopPage {
	
	private Logger log = LoggerHelper.getLogger(IosShopPage.class);
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	
	public IosShopPage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void clickOnSesrchIcon(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_SEARCH));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_SEARCH);
		_driver.findElement(IosShopPageLocators.IOSSHOP_SEARCH).click();
	}
	
	public void clickOnRegister(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_REGISTER));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_REGISTER);
		_driver.findElement(IosShopPageLocators.IOSSHOP_REGISTER).click();
	}
	
	public void inputShopItemToSearch(String shoppingItem) throws Exception{
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_SEARCHTEXTFIELD));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_SEARCHTEXTFIELD);
		_driver.findElement(IosShopPageLocators.IOSSHOP_SEARCHTEXTFIELD).sendKeys(shoppingItem);
	}
	
	public void inputFirstName(String firstName){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_FIRSTNAME));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_FIRSTNAME);
		_driver.findElement(IosShopPageLocators.IOSSHOP_FIRSTNAME).sendKeys(firstName);
	}
	
	public void inputLastName(String lastName){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_LASTNAME));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_LASTNAME);
		_driver.findElement(IosShopPageLocators.IOSSHOP_LASTNAME).sendKeys(lastName);
	}
	
	public void inputEmail(String email){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_EMAIL));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_EMAIL);
		_driver.findElement(IosShopPageLocators.IOSSHOP_EMAIL).sendKeys(email);
	}
	
	public void inputPassword(String password){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_PASSWORD));
		log.info("Waiting for the element:"+ IosShopPageLocators.IOSSHOP_PASSWORD);
		_driver.findElement(IosShopPageLocators.IOSSHOP_PASSWORD).sendKeys(password);
	}
	
	public void clickOnCreate() throws InterruptedException{
		
		_driver.findElementByAccessibilityId(IosShopPageLocators.IOSSHOP_CREATE).click();
		Thread.sleep(6000);
		
	}
	
	public boolean verifyLoginScreenAvailability(){
		WebDriverWait wait= new WebDriverWait(_driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosShopPageLocators.IOSSHOP_LOGIN));
		boolean status=_driver.findElement(IosShopPageLocators.IOSSHOP_LOGIN).isDisplayed();
		return status;
	}

}