package com.australianopen.android.pages;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.MorePageAndroidLocators;
import com.australianopen.android.locators.ShopPageAndroidLocators;
import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.android.locators.WhatsOnPageAndroidLocators;
import com.australianopen.android.locators.WomensPageAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import android.annotation.Dimension;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ShopPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(ShopPage.class);

	public ShopPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public void resetCart() {
		WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopPageAndroidLocators.SHOP_TOGGLECART_VIEW));
		String cartcount= driver.findElement(ShopPageAndroidLocators.SHOP_TOGGLECART_VIEW).getText();
		System.out.println("Cart count"+cartcount);
		if(!(cartcount.equalsIgnoreCase(""))) {
			driver.findElement(ShopPageAndroidLocators.SHOP_TOGGLECART_VIEW).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopPageAndroidLocators.SHOP_QUANTITY_EDITTEXT));
			driver.findElement(ShopPageAndroidLocators.SHOP_QUANTITY_EDITTEXT).clear();
			driver.findElement(ShopPageAndroidLocators.SHOP_QUANTITY_EDITTEXT).sendKeys("0"+"\n");
			driver.findElement(ShopPageAndroidLocators.SHOP_TOGGLECART_VIEW).click();
			
		}
	}

	public WomensPage clickOnWomensImage() throws InterruptedException {
		try {
			Thread.sleep(8000);
			
			TouchAction action = new TouchAction(driver);
			action.press(new PointOption().withCoordinates(0, 600)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 100)).release().perform();
					
		
			
			testLog.log(LogStatus.INFO, "Clicking on Womens Image in Shop page");
		
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
	
			testLog.log(LogStatus.INFO,"Waiting for the element:"+ShopPageAndroidLocators.SHOP_WOMENS_IMAGE);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopPageAndroidLocators.SHOP_WOMENS_IMAGE));
			driver.findElement(ShopPageAndroidLocators.SHOP_WOMENS_IMAGE).click();		
		
			
		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +ShopPageAndroidLocators.SHOP_WOMENS_IMAGE);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ShopPageAndroidLocators.SHOP_WOMENS_IMAGE);
		}
		return new WomensPage(driver, testLog);
	}
	
	


}