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

import com.australianopen.android.locators.CheckoutPageAndroidLocators;
import com.australianopen.android.locators.MorePageAndroidLocators;
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

public class CheckoutPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MensPage.class);
	
	public CheckoutPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public void verifyTotals() throws InterruptedException {
		try {
			Thread.sleep(5000);
			//TouchAction action = new TouchAction(driver);
			//action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 300)).release().perform();
		//	action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 700)).release().perform();		
		
			testLog.log(LogStatus.INFO, "Checking Amount displayed on checkout page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN);
			System.out.println(driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN).getText());	
			String amountOrderSummary=driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN).getText();
			amountOrderSummary=amountOrderSummary.substring(amountOrderSummary.lastIndexOf("$") + 1);
			System.out.println("Amount order summary"+amountOrderSummary);
			
			driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_PRICE_PRODUCTS_TBL_VIEW));
			String priceProductsTbl=driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_PRICE_PRODUCTS_TBL_VIEW).getText();
			priceProductsTbl=priceProductsTbl.substring(priceProductsTbl.lastIndexOf("$") + 1);
			System.out.println("priceProductsTbl after showing order summary"+priceProductsTbl);
			
			String subtotal=driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_SUBTOTAL_VIEW).getText();
			subtotal=subtotal.substring(subtotal.lastIndexOf("$") + 1);
			System.out.println("Subtotal after showing order summary"+subtotal);
			
			String total=driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_TOTAL_VIEW).getText();
			total=total.substring(total.lastIndexOf("$") + 1);
			System.out.println("Total after showing order summary"+total);
			
			driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_AMT_BTN).click();
			
			
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ShoppingCartPageAndroidLocators.SHOPPINGCART_CHECKOUT_BTN);
		}
		//return new ItemDetailPage(driver, testLog);
	}
	
	public void clickContinueButton() throws InterruptedException {
		try {
			Thread.sleep(5000);
			TouchAction action = new TouchAction(driver);
			action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 300)).release().perform();
		 	action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 700)).release().perform();		
		
			testLog.log(LogStatus.INFO, "Clicking on continue to shipping button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			//String uiSelector = "new UiSelector().text(\"Refund policy\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"continue_button\"));";
	        WebElement e=driver.findElementByAndroidUIAutomator(command);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_CONTINUE_TO_SHIPPING_BTN));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+CheckoutPageAndroidLocators.CHECKOUT_CONTINUE_TO_SHIPPING_BTN);
			
			driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_CONTINUE_TO_SHIPPING_BTN).click();	
	        
	        
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +CheckoutPageAndroidLocators.CHECKOUT_CONTINUE_TO_SHIPPING_BTN);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+CheckoutPageAndroidLocators.CHECKOUT_CONTINUE_TO_SHIPPING_BTN);
		}
	 //	return new ItemDetailPage(driver, testLog);
	}
	
	public String verifyValidEmailMessage() throws InterruptedException {
		String emailRequiredMessage = null;
		try {
			String uiSelector = "new UiSelector().textMatches(\"Enter a valid email\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO,"Verifying Enter a valid email message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_EMAIL_ERROR_TEXT));
			emailRequiredMessage = driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_EMAIL_ERROR_TEXT).getText();
			System.out.println(emailRequiredMessage);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + CheckoutPageAndroidLocators.CHECKOUT_EMAIL_ERROR_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + CheckoutPageAndroidLocators.CHECKOUT_EMAIL_ERROR_TEXT);
		}
		return emailRequiredMessage;
	}
	
	public String verifyFirstNameMessage() throws InterruptedException {
		String firstnameRequiredMessage = null;
		try {
			String uiSelector = "new UiSelector().textMatches(\"Enter a first name\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO,"Verifying Enter a first name message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_FIRSTNAME_ERROR_TEXT));
			firstnameRequiredMessage = driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_FIRSTNAME_ERROR_TEXT).getText();
			System.out.println(firstnameRequiredMessage);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + CheckoutPageAndroidLocators.CHECKOUT_FIRSTNAME_ERROR_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + CheckoutPageAndroidLocators.CHECKOUT_FIRSTNAME_ERROR_TEXT);
		}
		return firstnameRequiredMessage;
	}
	
	public String verifyLastNameMessage() throws InterruptedException {
		String lastnameRequiredMessage = null;
		try {
			String uiSelector = "new UiSelector().textMatches(\"Enter a last name\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO,"Verifying Enter a last name message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageAndroidLocators.CHECKOUT_LASTNAME_ERROR_TEXT));
			lastnameRequiredMessage = driver.findElement(CheckoutPageAndroidLocators.CHECKOUT_LASTNAME_ERROR_TEXT).getText();
			System.out.println(lastnameRequiredMessage);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + CheckoutPageAndroidLocators.CHECKOUT_LASTNAME_ERROR_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + CheckoutPageAndroidLocators.CHECKOUT_LASTNAME_ERROR_TEXT);
		}
		return lastnameRequiredMessage;
	}
	
	
}
