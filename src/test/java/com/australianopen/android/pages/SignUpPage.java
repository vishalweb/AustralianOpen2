package com.australianopen.android.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.australianopen.utils.LoggerHelper;

public class SignUpPage {

	private AndroidDriver<WebElement> driver;
	Logger log=LoggerHelper.getLogger(SignUpPage.class);
	public static long DYNAMIC_WAIT =70;
	

	public SignUpPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	
}
