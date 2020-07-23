package com.australianopen.android.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.australianopen.android.locators.ConditionsOfUseAndroidLocators;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class ConditionsOfUsePage{
	
	private AndroidDriver<WebElement> driver;
	ExtentTest testLog;
	public static long DYNAMIC_WAIT=40;
	
	public ConditionsOfUsePage(AndroidDriver<WebElement> driver,ExtentTest testLog)  {
		this.driver = driver;
		this.testLog=testLog;
	}

	public void clickOnMenuButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Menu button in Conditions of use Page");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MENU_BUTTON));
			testLog.log(LogStatus.INFO, "Waiting for the visibility of Menu button");
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MENU_BUTTON).click();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO, "Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MENU_BUTTON);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO, "Timeout after waiting" + DYNAMIC_WAIT + "seconds for:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MENU_BUTTON);
		}
	}
	
	public void clickOnContactButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Contact Button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACT_BUTTON));
			testLog.log(LogStatus.INFO, "Waiting for the visibility of Contact button");
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACT_BUTTON).click();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO, "Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACT_BUTTON);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO, "Timeout after waiting" + DYNAMIC_WAIT + "seconds for:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACT_BUTTON);
		}
	}
	
	public void enterFirstName(String firstName) {
		try {
			testLog.log(LogStatus.INFO,"Entering First Name");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_FIRSTNAME_TEXTFILED));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_FIRSTNAME_TEXTFILED);
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_FIRSTNAME_TEXTFILED).sendKeys(firstName);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_FIRSTNAME_TEXTFILED);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_FIRSTNAME_TEXTFILED);
		}
	}
	
	public void enterLastName(String lastName) {
		try {
			testLog.log(LogStatus.INFO,"Entering Last Name");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_LASTNAME_TEXTFILED));
			testLog.log(LogStatus.INFO,"Waiting for the element:"+ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_LASTNAME_TEXTFILED);
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_LASTNAME_TEXTFILED).sendKeys(lastName);
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_LASTNAME_TEXTFILED);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting"+DYNAMIC_WAIT+ "seconds for:"+ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_LASTNAME_TEXTFILED);
		}
	}
	
	public void clickOnPrivacyCheckbox() throws InterruptedException {
		try {
			String uiSelector = "new UiSelector().textMatches(\"Submit\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO, "Clicking on Privacy checkbox");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_PRIVACY_CHECKBOX));
			testLog.log(LogStatus.INFO, "Waiting for the visibility of Privacy checkbox");
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_PRIVACY_CHECKBOX).click();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO, "Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_PRIVACY_CHECKBOX);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO, "Timeout after waiting" + DYNAMIC_WAIT + "seconds for:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_PRIVACY_CHECKBOX);
		}
	}
	
	public void clickOnSubmitButton() {
		try {
			testLog.log(LogStatus.INFO, "Clicking on Submit Button");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_SUBMIT_BUTTON));
			testLog.log(LogStatus.INFO, "Waiting for the visibility of Submit Button");
			driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_SUBMIT_BUTTON).click();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO, "Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_SUBMIT_BUTTON);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO, "Timeout after waiting" + DYNAMIC_WAIT + "seconds for:"+ ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_SUBMIT_BUTTON);
		}
	}

	public String verifyEmailRequiredMessage() throws InterruptedException {
		String emailRequiredMessage = null;
		try {
			String uiSelector = "new UiSelector().textMatches(\"Email is required.\")";
	        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
	        driver.findElementByAndroidUIAutomator(command);
			testLog.log(LogStatus.INFO,"Verifying Email is Required message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_EMAILREQUIRED_TEXT));
			emailRequiredMessage = driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_EMAILREQUIRED_TEXT).getText();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_EMAILREQUIRED_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_EMAILREQUIRED_TEXT);
		}
		return emailRequiredMessage;
	}
	
	public String verifyContactPhoneRequiredMessage() {
		String contactPhoneRequiredMessage = null;
		try {
			testLog.log(LogStatus.INFO,"Verifying Contact Phone is Required message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACTPHONEREQUIRED_TEXT));
			contactPhoneRequiredMessage = driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACTPHONEREQUIRED_TEXT).getText();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACTPHONEREQUIRED_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_CONTACTPHONEREQUIRED_TEXT);
		}
		return contactPhoneRequiredMessage;
	}
	
	public String verifyStateRequiredMessage() {
		String stateRequiredMessage = null;
		try {
			testLog.log(LogStatus.INFO,"Verifying State is Required message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_STATEREQUIRED_TEXT));
			stateRequiredMessage = driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_STATEREQUIRED_TEXT).getText();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_STATEREQUIRED_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_STATEREQUIRED_TEXT);
		}
		return stateRequiredMessage;
	}
	
	public String verifyEnquiryTypeRequiredMessage() {
		String enquiryTypeRequiredMessage = null;
		try {
			testLog.log(LogStatus.INFO,"Verifying Enquiry Type is Required message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_ENQUIRYTYPEREQUIRED_TEXT));
			enquiryTypeRequiredMessage = driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_ENQUIRYTYPEREQUIRED_TEXT).getText();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_ENQUIRYTYPEREQUIRED_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_ENQUIRYTYPEREQUIRED_TEXT);
		}
		return enquiryTypeRequiredMessage;
	}
	
	public String verifyMessageRequiredMessage() {
		String messageRequiredMessage = null;
		try {
			testLog.log(LogStatus.INFO,"Verifying Message is Required message");
			WebDriverWait wait = new WebDriverWait(driver, DYNAMIC_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MESSAGEREQUIRED_TEXT));
			messageRequiredMessage = driver.findElement(ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MESSAGEREQUIRED_TEXT).getText();
		} catch (NoSuchElementException e) {
			testLog.log(LogStatus.INFO,"Element not found:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MESSAGEREQUIRED_TEXT);
		} catch (TimeoutException e) {
			testLog.log(LogStatus.INFO,"Timeout after waiting" + DYNAMIC_WAIT + "seconds for:" + ConditionsOfUseAndroidLocators.CONDITIONSOFUSE_MESSAGEREQUIRED_TEXT);
		}
		return messageRequiredMessage;
	}
	
	
}
