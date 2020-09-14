package com.australianopen.android.locators;

import org.openqa.selenium.By;

public class WomensPageAndroidLocators {

	//public static final By WOMENS_SECONDTSHIRT_IMAGE =By.xpath("//android.widget.Image[@text='ALT005_AO2020_T-Shirt-Summer-Dated_1_large']"); 
	
	public static final By WOMENS_SECONDTSHIRT_IMAGE = By.xpath("//android.view.View[@content-desc='t-shirt-summer-dated']");

	public static final By WOMENS_SECONDTSHIRT_AMT = By.xpath("//android.view.View[@content-desc='t-shirt-summer-dated']/following-sibling::android.view.View[2]");
	
}
