package com.australianopen.android.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.australianopen.android.pages.CheckoutPage;
import com.australianopen.android.pages.ItemDetailPage;
import com.australianopen.android.pages.MensPage;
import com.australianopen.android.pages.MorePage;
import com.australianopen.android.pages.ShopPage;
import com.australianopen.android.pages.ShoppingCartPage;
import com.australianopen.android.pages.WelcomePage;
import com.australianopen.android.pages.WhatsOnPage;
import com.australianopen.android.pages.WomensPage;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.LogStatus;

public class AndroidPOCTest extends BaseTestSuite {
		
	//private Logger log=LoggerHelper.getLogger(AndroidPOCTest.class);
	
	public static final String EMAIL_IS_REQUIRED_MSG = "Enter a valid email";
	public static final String FIRSTNAME_IS_REQUIRED_MSG = "Enter a first name";
	public static final String LASTNAME_IS_REQUIRED_MSG = "Enter a last name";

	
	@Test
	public void TC001(Method method) throws InterruptedException, UnsupportedEncodingException {
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO,"Executing shoppingcart test");
		WelcomePage welcomePage = new WelcomePage(driver,testLog);
		WhatsOnPage whatsOnPage = welcomePage.clickOnSkipAllButton();
		MorePage morePage = whatsOnPage.clickOnMoreButton();
		ShopPage shopPage = morePage.clickOnShopOption();
		//shopPage.resetCart();
		WomensPage womensPage=shopPage.clickOnWomensImage();
		String priceonwomenpage= womensPage.getItemPriceOnWomensPage(); 
		ItemDetailPage itemdetailsPage = womensPage.clickOnItem();
		String priceonitemdetailpage= itemdetailsPage.getPriceOnItemDetailPage();
		//priceonitemdetailpage=priceonitemdetailpage.replaceAll(new String("Â".getBytes("UTF-8"), "UTF-8"), "");
		System.out.println("priceonwomenpage"+priceonwomenpage+ " priceonitemdetailpage" + priceonitemdetailpage.substring(0,2));
		
		//Assertion 1
		Assert.assertEquals(priceonwomenpage, priceonitemdetailpage.substring(0,2));
		ShoppingCartPage shoppingcartPage=itemdetailsPage.clickAddtoCart();
		//merged scenario of removing from cart and adding to cart
		shoppingcartPage.resetCart();
		shoppingcartPage.increaseQuantity();
		shoppingcartPage=itemdetailsPage.clickAddtoCart();
		
		//Assertion 2
		shoppingcartPage.checkPriceQuantitySubtotal();
		
		CheckoutPage checkoutPage=shoppingcartPage.clickOnCheckout();
		
		//Assertion 3
		checkoutPage.verifyTotals();
		checkoutPage.clickContinueButton();
		
		//Assertion 4
		Assert.assertEquals(checkoutPage.verifyValidEmailMessage(), EMAIL_IS_REQUIRED_MSG);
		Assert.assertEquals(checkoutPage.verifyFirstNameMessage(), FIRSTNAME_IS_REQUIRED_MSG);
		Assert.assertEquals(checkoutPage.verifyLastNameMessage(), LASTNAME_IS_REQUIRED_MSG);
		
		
	}
	
	
	
}
