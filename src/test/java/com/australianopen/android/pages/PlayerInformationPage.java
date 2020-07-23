package com.australianopen.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.australianopen.android.locators.PlayerInformationPageAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class PlayerInformationPage {
	
	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MorePage.class);
	
	public PlayerInformationPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public void clickOnFavouriteButton() throws InterruptedException {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Favourite button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayerInformationPageAndroidLocators.PLAYERINFO_FAVOURITE_BUTTON));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+PlayerInformationPageAndroidLocators.PLAYERINFO_FAVOURITE_BUTTON);
			 Thread.sleep(4000);
			driver.findElement(PlayerInformationPageAndroidLocators.PLAYERINFO_FAVOURITE_BUTTON).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +PlayerInformationPageAndroidLocators.PLAYERINFO_FAVOURITE_BUTTON);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+PlayerInformationPageAndroidLocators.PLAYERINFO_FAVOURITE_BUTTON);
		}
	}
	
	public PlayersPage clickOnBackButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on back button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayerInformationPageAndroidLocators.PLAYERINFO_BACK_BUTTON));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+PlayerInformationPageAndroidLocators.PLAYERINFO_BACK_BUTTON);
			driver.findElement(PlayerInformationPageAndroidLocators.PLAYERINFO_BACK_BUTTON).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +PlayerInformationPageAndroidLocators.PLAYERINFO_BACK_BUTTON);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+PlayerInformationPageAndroidLocators.PLAYERINFO_BACK_BUTTON);
		}
		return new PlayersPage(driver, testLog);
	}

}
