package com.australianopen.android.locators;

import org.openqa.selenium.By;

public class CheckoutPageAndroidLocators {

	
	public static final By CHECKOUT_AMT_BTN = By.xpath("//android.webkit.WebView/android.view.View[3]/android.widget.Button");
	public static final By CHECKOUT_PRICE_PRODUCTS_TBL_VIEW = By.xpath("(//android.view.View[@text='T-Shirt Summer Dated L'])[1]/following-sibling::android.view.View[2]");
	public static final By CHECKOUT_SUBTOTAL_VIEW = By.xpath("//android.view.View[@text='Subtotal']/following-sibling::android.view.View");
	public static final By CHECKOUT_TOTAL_VIEW = By.xpath("//android.widget.TextView[@text='AUD']/following-sibling::android.widget.TextView[2]");
	public static final By CHECKOUT_CONTINUE_TO_SHIPPING_BTN = By.xpath("//android.widget.Button[@text='Continue to shipping']");
	public static final By CHECKOUT_EMAIL_ERROR_TEXT = By.xpath("//android.view.View[@resource-id='error-for-email']");
	public static final By CHECKOUT_FIRSTNAME_ERROR_TEXT = By.xpath("//android.view.View[@resource-id='error-for-first_name']");
	public static final By CHECKOUT_LASTNAME_ERROR_TEXT = By.xpath("//android.view.View[@resource-id='error-for-last_name']");
	public static final By CHECKOUT_ADDRESS_ERROR_TEXT = By.xpath("//android.view.View[@resource-id='error-for-address1']");
}
