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

public class WomensPage {

	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	private Logger log = LoggerHelper.getLogger(MensPage.class);
	
	public WomensPage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}
	
	public ItemDetailPage clickOnItem() throws InterruptedException {
		try {
			Thread.sleep(5000);
			TouchAction action = new TouchAction(driver);
			//action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 300)).release().perform();
		//	action.press(new PointOption().withCoordinates(0, 1186)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(new PointOption().withCoordinates(0, 700)).release().perform();		
		
			testLog.log(LogStatus.INFO, "Clicking on tshirt");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE);
			/*String uiSelector = "new UiSelector().textMatches(\"ALT005_AO2020_T-Shirt-Summer-Dated_1_large\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        WebElement e=driver.findElementByAndroidUIAutomator(command);*/
	        //e.click();
	        System.out.println("Amount"+driver.findElement(WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_AMT).getText());
	        TouchAction touchAction = new TouchAction(driver);
	        touchAction.tap(PointOption.point(29, 800)).perform();
			//driver.findElement(WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE).click();		
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_IMAGE);
		}
		return new ItemDetailPage(driver, testLog);
	}
	
	
	public String getItemPriceOnWomensPage() throws InterruptedException {
		String price= "";
		try {
			String uiSelector = "new UiSelector().textMatches(\"ALT005_AO2020_T-Shirt-Summer-Dated_1_large\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        WebElement e=driver.findElementByAndroidUIAutomator(command);
			String pricedisplayedonpage= driver.findElement(WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_AMT).getText();
			price=pricedisplayedonpage.substring(pricedisplayedonpage.lastIndexOf("$") + 1);
			System.out.println(pricedisplayedonpage);
			System.out.println("price on womens page"+price);
			
		}catch(NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" +WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_AMT);
		}catch(TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+WomensPageAndroidLocators.WOMENS_SECONDTSHIRT_AMT);
		}
		return price;
	}
	
	
}
