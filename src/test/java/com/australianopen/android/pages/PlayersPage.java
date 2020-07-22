package com.australianopen.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.ConditionsOfUseAndroidLocators;
import com.australianopen.android.locators.MorePageAndroidLocators;
import com.australianopen.android.locators.PlayerInformationPageAndroidLocators;
import com.australianopen.android.locators.PlayersPageAndroidLocators;
import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class PlayersPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MorePage.class);

	public PlayersPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}

	public void enterPlayerNameInSearchBar(String playerName) {
		try {
			testLog.log(LogStatus.INFO,"Entering player name in search bar");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayersPageAndroidLocators.PLAYERS_SEARCHBAR));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+PlayersPageAndroidLocators.PLAYERS_SEARCHBAR);
			driver.findElement(PlayersPageAndroidLocators.PLAYERS_SEARCHBAR).sendKeys(playerName);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:"+ PlayersPageAndroidLocators.PLAYERS_SEARCHBAR);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+PlayersPageAndroidLocators.PLAYERS_SEARCHBAR);
		}
	}


	public PlayerInformationPage selectFavouritePlayers() {
		try {
			testLog.log(LogStatus.INFO, "Selecting favourite player");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER);
			driver.findElement(PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER);
		}
		return new PlayerInformationPage(driver, testLog);
	}

	public void clickOnFavouritesTab() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Favourites tab");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB);
			driver.findElement(PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB);
		}
	}

	public boolean verifyFavoritePlayer() {
		boolean status = false;
		try {
			testLog.log(LogStatus.INFO, "Verifying Sign Out verification message in menu Page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB_FAVPLAYER));
			testLog.log(LogStatus.INFO, "Waiting for Signout Verification Message in Menu Page");
			status = driver.findElement(PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB_FAVPLAYER).isDisplayed();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO, "Element not found:" + PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB_FAVPLAYER);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO, "Timeout after waiting" + DYNAMIC_WAIT + "seconds for:"+ PlayersPageAndroidLocators.PLAYERS_FAVOURITESTAB_FAVPLAYER);
		}
		return status;
	}

	public boolean verifyFavoriteSectionIsBlank(){
		try{
			Thread.sleep(4000);
			driver.findElement(PlayersPageAndroidLocators.PLAYERS_SELECTFAVPLAYER);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
