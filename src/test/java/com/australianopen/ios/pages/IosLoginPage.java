package com.australianopen.ios.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.australianopen.utils.LoggerHelper;

import io.appium.java_client.ios.IOSDriver;

public class IosLoginPage {
	private Logger log = LoggerHelper.getLogger(IosLoginPage.class);
	private IOSDriver<WebElement> _driver;
	public static long DYNAMIC_WAIT=60;
	
	public IosLoginPage(IOSDriver<WebElement> _driver) {
		this._driver = _driver;
	}

	
}
