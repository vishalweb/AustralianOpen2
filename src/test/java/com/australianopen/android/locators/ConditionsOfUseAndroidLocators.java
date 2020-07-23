package com.australianopen.android.locators;

import org.openqa.selenium.By;

public class ConditionsOfUseAndroidLocators {
	
	public static final By CONDITIONSOFUSE_MENU_BUTTON = By.xpath("//android.view.View[@content-desc='Menu']");
	public static final By CONDITIONSOFUSE_CONTACT_BUTTON = By.xpath("//android.view.View[@content-desc='Contact']");
	public static final By CONDITIONSOFUSE_FIRSTNAME_TEXTFILED = By.xpath("(//android.widget.EditText)[1]");
	public static final By CONDITIONSOFUSE_LASTNAME_TEXTFILED = By.xpath("(//android.widget.EditText)[2]");
	public static final By CONDITIONSOFUSE_PRIVACY_CHECKBOX = By.xpath("//android.widget.CheckBox[@resource-id='privacy']");
	public static final By CONDITIONSOFUSE_SUBMIT_BUTTON = By.xpath("//android.widget.Button[@text='Submit']");
	public static final By CONDITIONSOFUSE_EMAILREQUIRED_TEXT = By.xpath("//android.view.View[@text='Email is required.']");
	public static final By CONDITIONSOFUSE_CONTACTPHONEREQUIRED_TEXT = By.xpath("//android.view.View[@text='Contact Phone is required.']");
	public static final By CONDITIONSOFUSE_STATEREQUIRED_TEXT = By.xpath("//android.view.View[@text='State is required.']");
	public static final By CONDITIONSOFUSE_ENQUIRYTYPEREQUIRED_TEXT = By.xpath("//android.view.View[@text='Enquiry type is required.']");
	public static final By CONDITIONSOFUSE_MESSAGEREQUIRED_TEXT = By.xpath("//android.view.View[@text='Message is required.']");
}
