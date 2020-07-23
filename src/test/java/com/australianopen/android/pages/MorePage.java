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

	public ConditionsOfUsePage clickOnConditionsOfUse() throws InterruptedException {
		try {
			String uiSelector = "new UiSelector().textMatches(\"Conditions of Use\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO, "Clicking on Skip All button in Welcome page");
			log.info("Clicking on Skip All button in Welcome page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(MorePageAndroidLocators.MORE_CONDITIONSOFUSE));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
			log.info("Waiting for the element:"+MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
			driver.findElement(MorePageAndroidLocators.MORE_CONDITIONSOFUSE).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
			log.info("Element not found:" +MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
			log.info("Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_CONDITIONSOFUSE);
		}
		return new ConditionsOfUsePage(driver, testLog);
	}
	
	public PlayersPage clickOnPlayersOption() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Players in More page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(MorePageAndroidLocators.MORE_PLAYERS));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+MorePageAndroidLocators.MORE_PLAYERS);
			driver.findElement(MorePageAndroidLocators.MORE_PLAYERS).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +MorePageAndroidLocators.MORE_PLAYERS);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+MorePageAndroidLocators.MORE_PLAYERS);
		}
		return new PlayersPage(driver, testLog);
	}
}
