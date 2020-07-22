package com.australianopen.ios.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.australianopen.utils.ConfigFileReader;
import com.australianopen.utils.LoggerHelper;

import io.appium.java_client.ios.IOSDriver;

public class IosSignUpPage {
	private Logger log = LoggerHelper.getLogger(IosSignUpPage.class);
	private IOSDriver<WebElement> _driver;
	public static long DYNAMIC_WAIT=20;
	private ConfigFileReader config = new ConfigFileReader();
	
	public static final String PASSWORD_RULE_TXT = "Use 8 or more characters with a mix of uppercase or lowercase letters, numbers & symbols";
	

	public IosSignUpPage(IOSDriver<WebElement> _driver) {
		this._driver = _driver;
	}
	
	
}
