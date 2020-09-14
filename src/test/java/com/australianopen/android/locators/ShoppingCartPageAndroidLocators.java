package com.australianopen.android.locators;
import org.openqa.selenium.By;

public class ShoppingCartPageAndroidLocators {
	public static final By SHOPPINGCART_TOGGLECART_VIEW = By.xpath("//android.view.View[@resource-id='toggleCartDrawer']");
	public static final By SHOPPINGCART_QUANTITY_EDITTEXT = By.xpath("(//android.widget.EditText)[2]");
	public static final By SHOPPINGCART_QUANTITY_INCREASE_BTN = By.xpath("(//android.widget.Button)[5]");
	public static final By SHOPPINGCART_CHECKOUT_BTN = By.xpath("//android.widget.Button[@text='CHECK OUT']");
	public static final By SHOPPINGCART_PRODUCTTABLE_PRICE_TEXT = By.xpath("//android.view.View[@content-desc='t-shirt-summer-dated?variant=31362947940412']/following-sibling::android.view.View[2]");
	public static final By SHOPPINGCART_PRODUCTTABLE_QUANTITY_TEXT = By.xpath("//android.view.View[@content-desc='t-shirt-summer-dated?variant=31362947940412']/following-sibling::android.widget.EditText");
	public static final By SHOPPINGCART_SUBTOTAL_TEXT = By.xpath("//android.view.View[@text='Subtotal']/following-sibling::android.view.View[1]");
}
