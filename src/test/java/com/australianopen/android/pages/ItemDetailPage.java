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

import com.australianopen.android.locators.ItemDetailPageAndroidLocators;
import com.australianopen.android.locators.MorePageAndroidLocators;
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

public class ItemDetailPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MensPage.class);
	
	public ItemDetailPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public ShoppingCartPage clickAddtoCart() throws InterruptedException {
		try {
			Thread.sleep(5000);
			/*TouchAction action = new TouchAction(driver);
			action.press(new PointOption().withCoordinates(56, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(56, 852)).release().perform();
		    action.press(new PointOption().withCoordinates(56, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(56, 852)).release().perform();		
		*/
			testLog.log(LogStatus.INFO, "Clicking on add to cart");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(ItemDetailPageAndroidLocators.ITEMDETAIL_ADDTOCART_BTN));
			//testLog.log(LogStatus.INFO,"Waiting for the element:"+ItemDetailPageAndroidLocators.ITEMDETAIL_ADDTOCART_BTN);
			/*String uiSelector = "new UiSelector().textMatches(\"Quantity\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        WebElement e=driver.findElementByAndroidUIAutomator(command);*/
	       // driver.findElement(ItemDetailPageAndroidLocators.ITEMDETAIL_ADDTOCART_BTN).click();	
	       // e.click();
	       TouchAction touchAction = new TouchAction(driver);
	       touchAction.tap(PointOption.point(100, 1250)).perform();
			//driver.findElement(WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +ItemDetailPageAndroidLocators.ITEMDETAIL_ADDTOCART_BTN);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ItemDetailPageAndroidLocators.ITEMDETAIL_ADDTOCART_BTN);
		}
		return new ShoppingCartPage(driver, testLog);
	}
	
	public String getPriceOnItemDetailPage() throws InterruptedException {
		String price= "";
		try {
			Thread.sleep(5000);
			TouchAction action = new TouchAction(driver);
			action.press(new PointOption().withCoordinates(56, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(56, 852)).release().perform();
		    action.press(new PointOption().withCoordinates(56, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(56, 852)).release().perform();		
		
			String pricedisplayedonpage= driver.findElement(ItemDetailPageAndroidLocators.ITEMDETAIL_PRICE).getText();
			System.out.println("item details before substring"+pricedisplayedonpage);
			price=pricedisplayedonpage.substring(pricedisplayedonpage.indexOf("$") + 1, pricedisplayedonpage.indexOf(" "));
			System.out.println("item details"+price);
			price=price.replace("Â", "");
			
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +ItemDetailPageAndroidLocators.ITEMDETAIL_PRICE);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ItemDetailPageAndroidLocators.ITEMDETAIL_PRICE);
		}
		return price;
	}
	
}
	