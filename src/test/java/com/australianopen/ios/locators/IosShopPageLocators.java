package com.australianopen.ios.locators;

import org.openqa.selenium.By;

public class IosShopPageLocators {

	public static final By IOSSHOP_REGISTER=By.xpath("//XCUIElementTypeStaticText[@name='REGISTER']");
	public static final By IOSSHOP_FIRSTNAME=By.xpath("//XCUIElementTypeTextField[@value='First Name']");
	public static final By IOSSHOP_LASTNAME=By.xpath("//XCUIElementTypeTextField[@value='Last Name']");
	public static final By IOSSHOP_EMAIL=By.xpath("//XCUIElementTypeTextField[@value='Email']");
	public static final By IOSSHOP_PASSWORD=By.xpath("//XCUIElementTypeSecureTextField[@value='Password']");
	public static final By IOSSHOP_SUBSCRIPTION=By.xpath("//XCUIElementTypeOther[contains(@name,'Subscribe to stay updated')]");
	public static final By IOSSHOP_SEARCH=By.xpath("//XCUIElementTypeTextField[@value='Search']");
	public static final By IOSSHOP_SEARCHTEXTFIELD=By.xpath("(//XCUIElementTypeTextField[@value='Search'])[2]");
	public static final String IOSSHOP_CREATE="Create";
	public static final By IOSSHOP_LOGIN=By.xpath("//XCUIElementTypeStaticText[@name='Login']");
}
