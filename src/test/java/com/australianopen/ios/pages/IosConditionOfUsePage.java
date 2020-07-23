package com.australianopen.ios.pages;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.apache.tools.ant.types.resources.Last;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.australianopen.ios.locators.IosConditionOfUsePagelocators;
import com.australianopen.ios.locators.IosMorePageLocators;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;

public class IosConditionOfUsePage {
	
	private IOSDriver<WebElement> _driver;
	private ExtentTest testLog;
	public static long DYNAMIC_WAIT=20;
	
	public IosConditionOfUsePage(IOSDriver<WebElement> _driver,ExtentTest testLog) {
		this._driver = _driver;
		this.testLog=testLog;
	}
	
	public void validateConditionOfUsePage(){
		boolean status=_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_TEXT).isDisplayed();
		try{
			if(status){
				testLog.log(LogStatus.INFO,"More Page is displayed");
			}
		}catch(NoSuchElementException e){
			testLog.log(LogStatus.INFO,"More page is not displayed");
		}
	}
	
	public void clickOnSandwichIcon(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SANDWICH_OPTION));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SANDWICH_OPTION);
		_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SANDWICH_OPTION).click();
		
	}
	
	public void clickOnContact(){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_OPTION));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_OPTION);
		_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_OPTION).click();
	}
	
	public void InputFirstName(String FirstName){
		WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_FIRSTNAME));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_FIRSTNAME);
		_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_FIRSTNAME).sendKeys(FirstName);
	}

   public void InputLastName(String LastName){
	WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
	wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_LASTNAME));
	testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_LASTNAME);
	_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_CONTACT_LASTNAME).sendKeys(LastName);
	}
   
   public void checkPrivacyPolicyStatement() throws TimeoutException{
   scrollUpWithJavaScript("Privacy policy");
   WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
	wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_PRIVACYPOLICY));
	testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_PRIVACYPOLICY);
	_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_PRIVACYPOLICY).click();
   }
   
   public void clickOnSubmitButton(){
	   WebDriverWait wait= new WebDriverWait(_driver,DYNAMIC_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SUBMITBTN));
		testLog.log(LogStatus.INFO,"Waiting for the element:"+ IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SUBMITBTN);
		_driver.findElement(IosConditionOfUsePagelocators.IOSCONDITION_OF_USE_SUBMITBTN).click();
   }
   
   public void scrollUpWithJavaScript(String text){
		JavascriptExecutor js = (JavascriptExecutor) _driver;
       HashMap<Object, Object> scrollObject = new HashMap<>();
       scrollObject.put("predicateString", "value == '" + text + "'");
       scrollObject.put("direction", "down");
            js.executeScript("mobile: scroll", scrollObject);
	}
   public void scrollDownWithJavaScript(String text){
		JavascriptExecutor js = (JavascriptExecutor) _driver;
      HashMap<Object, Object> scrollObject = new HashMap<>();
      scrollObject.put("predicateString", "value == '" + text + "'");
      scrollObject.put("direction", "up");
           js.executeScript("mobile: scroll", scrollObject);
	}
   
   public void validateRequiredFieldsValidationMessage(String fieldName){
	   scrollDownWithJavaScript("CONTACTS");
	   boolean status=_driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+fieldName+"']")).isDisplayed();
	   try{
			if(status){
				testLog.log(LogStatus.INFO,"Validation message for "+fieldName+" is displayed");
			}
		}catch(NoSuchElementException e){
			testLog.log(LogStatus.INFO,"Validation message for "+fieldName+" is not displayed");
		}
   }
}
