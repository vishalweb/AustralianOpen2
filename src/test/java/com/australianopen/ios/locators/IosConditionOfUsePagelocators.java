package com.australianopen.ios.locators;

import org.openqa.selenium.By;

public class IosConditionOfUsePagelocators {
	
	public static final By IOSCONDITION_OF_USE_TEXT=By.xpath("//XCUIElementTypeOther[@name='Conditions of Use']");
	public static final By IOSCONDITION_OF_USE_SANDWICH_OPTION=By.xpath("//XCUIElementTypeStaticText[@name='']");
	public static final By IOSCONDITION_OF_USE_CONTACT_OPTION=By.xpath("//XCUIElementTypeStaticText[@name='Contact']");
	public static final By IOSCONDITION_OF_USE_CONTACT_FIRSTNAME=By.xpath("//XCUIElementTypeOther[@name='Contacts | About Tennis Australia | Tennis Australia']/XCUIElementTypeOther[11]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]");
	public static final By IOSCONDITION_OF_USE_CONTACT_LASTNAME=By.xpath("//XCUIElementTypeOther[@name='Contacts | About Tennis Australia | Tennis Australia']/XCUIElementTypeOther[11]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]");
    public static final By IOSCONDITION_OF_USE_PRIVACYPOLICY=By.xpath("//XCUIElementTypeOther[@name='Contacts | About Tennis Australia | Tennis Australia']/XCUIElementTypeOther[11]/XCUIElementTypeOther[6]/XCUIElementTypeOther");
    public static final By IOSCONDITION_OF_USE_SUBMITBTN=By.xpath("//XCUIElementTypeButton[contains(@name,'Submit')]");

}
