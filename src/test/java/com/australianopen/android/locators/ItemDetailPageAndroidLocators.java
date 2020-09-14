package com.australianopen.android.locators;

import org.openqa.selenium.By;

public class ItemDetailPageAndroidLocators {
	
	public static final By ITEMDETAIL_INCREASEQTY_BTN = By.xpath("(//android.widget.Button)[11]");
	public static final By ITEMDETAIL_ADDTOCART_BTN =By.xpath("//android.widget.Button[@resource-id='AddToCart--product']");
	public static final By ITEMDETAIL_PRICE = By.xpath("//android.view.View[@text='T-Shirt Summer Dated']/following-sibling::android.view.View");

}
