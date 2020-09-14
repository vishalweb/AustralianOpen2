package com.australianopen.android.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.android.locators.MorePageAndroidLocators;
import com.australianopen.android.locators.ShopPageAndroidLocators;
import com.australianopen.android.locators.ShoppingCartPageAndroidLocators;
import com.australianopen.android.locators.WelcomeAndroidLocators;
import com.australianopen.android.locators.WhatsOnPageAndroidLocators;
import com.australianopen.android.locators.WomensPageAndroidLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class ShoppingCartPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MensPage.class);

	public ShoppingCartPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}

	public CheckoutPage clickOnCheckout() throws InterruptedException {
		try {
			Thread.sleep(5000);
			//TouchAction action = new TouchAction(driver);
			//action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 300)).release().perform();
			//	action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 700)).release().perform();		

			testLog.log(LogStatus.INFO, "Clicking on checkout button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN);
			driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN).click();	

		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN);
		}
		return new CheckoutPage(driver, testLog);
	}

	public void checkPriceQuantitySubtotal() {
		String pricedisplayedonpage= driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_PRODUCTTABLE_PRICE_TEXT).getText();
		String quantitydisplayedonpage= driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_PRODUCTTABLE_QUANTITY_TEXT).getText();
		String subtotaldisplayedonpage= driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_SUBTOTAL_TEXT).getText();

		pricedisplayedonpage =pricedisplayedonpage.substring(pricedisplayedonpage.lastIndexOf("$") + 1);
		subtotaldisplayedonpage =subtotaldisplayedonpage.substring(subtotaldisplayedonpage.lastIndexOf("$") + 1);
		float subtotaldisplayedtofloat=Float.parseFloat(subtotaldisplayedonpage);
		float price=Float.parseFloat(pricedisplayedonpage);
		int quantity= Integer.parseInt(quantitydisplayedonpage);
		float calcsubTotal=price*quantity;
		String calcsubTotalString = String.format("%.2f",calcsubTotal);
		String subTotalDisplayed = String.format("%.2f", subtotaldisplayedtofloat);
		System.out.println("Calculated Subtotal"+calcsubTotalString + "Displayed Subtotal"+subTotalDisplayed);
		Assert.assertEquals(calcsubTotalString, subTotalDisplayed);
	}

	public void resetCart() {
		WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPageAndroidLocators.SHOPPINGCART_TOGGLECART_VIEW));
		String cartcount= driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_TOGGLECART_VIEW).getText();
		System.out.println("Cart count"+cartcount);
		if(!(cartcount.equalsIgnoreCase(""))) {
			//driver.findElement(ShopPageAndroidLocators.SHOP_TOGGLECART_VIEW).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPageAndroidLocators.SHOPPINGCART_TOGGLECART_VIEW));
			driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_QUANTITY_EDITTEXT).clear();
			driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_QUANTITY_EDITTEXT).sendKeys("0"+"\n");
			driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_TOGGLECART_VIEW).click();

		}
	}

	public void increaseQuantity() {
		WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPageAndroidLocators.SHOPPINGCART_QUANTITY_INCREASE_BTN));
		driver.findElement(ShoppingCartPageAndroidLocators.SHOPPINGCART_QUANTITY_INCREASE_BTN).click();

	}



}
