package com.australianopen.ios.pages;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.ios.locators.IosFavoritePageLocators;
import com.australianopen.ios.locators.IosPlayerInformationPageLocators;
import com.australianopen.utils.ConfigFileReader;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.ios.IOSDriver;

public class IosFavoritesPage {

	
	private Logger log = LoggerHelper.getLogger(IosFavoritesPage.class);
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	ConfigFileReader config=new ConfigFileReader();
	
	public IosFavoritesPage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void verifyPlayerInFavioritePage() throws Exception{
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER));
		log.info("Waiting for the element:"+ IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER);
		String playerName=_driver.findElement(IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER).getAttribute("label");
		try{
			if(playerName.contains(config.getKey("PLAYER_NAME"))){
				log.info("Favorite player "+config.getKey("PLAYER_NAME")+" is displayed");
			}}catch(Exception e){
				log.info("Favorite player "+config.getKey("PLAYER_NAME")+" is not displayed");
			}		
	}
	
	public IosPlayerInformationPage clickOnFavoritePlayer(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER));
		log.info("Waiting for the element:"+ IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER);
		_driver.findElement(IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER).click();
		return new IosPlayerInformationPage(_driver, testLog);
	}
	
	public boolean verifyFavoriteSectionIsBlank(){
		try{
				_driver.findElement(IosFavoritePageLocators.IOS_FAVORITE_SELECTEDPLAYER);
			return true;
		}catch(Exception e){
			
		return false;
		}
	}
}
		
	

