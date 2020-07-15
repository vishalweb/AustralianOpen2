package com.australianopen.android.pages;

import org.openqa.selenium.WebElement;

import com.australianopen.utils.LoggerHelper;

import org.apache.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	private AndroidDriver<WebElement> driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	public static long DYNAMIC_WAIT = 60;

	public LoginPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	
}
