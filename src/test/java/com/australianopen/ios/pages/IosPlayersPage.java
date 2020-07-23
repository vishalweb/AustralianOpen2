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

public class IosPlayersPage {
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	
	public IosPlayersPage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void searchAPlayer(String playerName){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosPlayersPageLocators.IOSPLAYERS_FINDAPLAYER));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosPlayersPageLocators.IOSPLAYERS_FINDAPLAYER);
		_driver.findElement(IosPlayersPageLocators.IOSPLAYERS_FINDAPLAYER).sendKeys(playerName);
	}
	
	public IosPlayerInformationPage clickOnSearchedPlayer(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosPlayersPageLocators.IOSPLAYERS_SEARCHEDPLAYER));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosPlayersPageLocators.IOSPLAYERS_SEARCHEDPLAYER);
		_driver.findElement(IosPlayersPageLocators.IOSPLAYERS_SEARCHEDPLAYER).click();
		return new IosPlayerInformationPage(_driver,testLog);
	}
	
	public IosFavoritesPage clickOnFavoritesOption(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosPlayersPageLocators.IOSPLAYERS_FAVORITES_OPTION));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosPlayersPageLocators.IOSPLAYERS_FAVORITES_OPTION);
		_driver.findElement(IosPlayersPageLocators.IOSPLAYERS_FAVORITES_OPTION).click();
		return new IosFavoritesPage(_driver,testLog);
	}

}
