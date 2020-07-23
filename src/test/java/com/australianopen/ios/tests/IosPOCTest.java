package com.australianopen.ios.tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import com.australianopen.ios.pages.IosConditionOfUsePage;
import com.australianopen.ios.pages.IosFavoritesPage;
import com.australianopen.ios.pages.IosHomePage;
import com.australianopen.ios.pages.IosMorePage;
import com.australianopen.ios.pages.IosPlayerInformationPage;
import com.australianopen.ios.pages.IosPlayersPage;
import com.australianopen.ios.pages.IosShopPage;
import com.australianopen.utils.ConfigFileReader;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;

public class IosPOCTest extends IosBaseTestSuite{
	public ConfigFileReader config=new ConfigFileReader();
	
	@Test
	public void verifyContactFunctionalityCondition(Method method) throws Exception{
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO,"Executing verifyContactFunctionalityCondition test");
		IosHomePage homePage=new IosHomePage(_driver,testLog);
		IosMorePage morePage=homePage.clickOnMoreOption();
		morePage.validateMorePage();
		IosConditionOfUsePage conditionOfUsePage=morePage.clickOnConditionOfUseOption();
		conditionOfUsePage.validateConditionOfUsePage();
		//conditionOfUsePage.clickOnSandwichIcon();
		conditionOfUsePage.clickOnContact();
		conditionOfUsePage.InputFirstName(config.getKey("FIRSTNAME"));
		conditionOfUsePage.InputLastName(config.getKey("LASTNAME"));
		conditionOfUsePage.checkPrivacyPolicyStatement();
		conditionOfUsePage.clickOnSubmitButton();
		conditionOfUsePage.validateRequiredFieldsValidationMessage("Email");
		conditionOfUsePage.validateRequiredFieldsValidationMessage("Contact Phone");
		conditionOfUsePage.validateRequiredFieldsValidationMessage("State");
		conditionOfUsePage.validateRequiredFieldsValidationMessage("Enquiry type");
		conditionOfUsePage.validateRequiredFieldsValidationMessage("Message");		
		
	}
	
	@Test
	public void verifyFavoriteFunctionality(Method method) throws Exception{
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO,"Executing verifyFavoriteFunctionality test");
		IosHomePage homePage=new IosHomePage(_driver,testLog);
		IosMorePage morePage=homePage.clickOnMoreOption();
		morePage.validateMorePage();
		IosPlayersPage playersPage=morePage.clickOnPlayersOption();
		playersPage.searchAPlayer(config.getKey("PLAYER_NAME"));
		IosPlayerInformationPage playerInfoPage=playersPage.clickOnSearchedPlayer();
		playerInfoPage.clickOnFavoriteIcon();
		playersPage=playerInfoPage.clickOnBackButton();	
		IosFavoritesPage favoritesPage=playersPage.clickOnFavoritesOption();
		favoritesPage.verifyPlayerInFavioritePage();
		playerInfoPage=favoritesPage.clickOnFavoritePlayer();
		playerInfoPage.clickOnFavoriteIcon();
		playersPage=playerInfoPage.clickOnBackButton();	
		favoritesPage=playersPage.clickOnFavoritesOption();
		Assert.assertFalse(favoritesPage.verifyFavoriteSectionIsBlank());		
		
	}
	
	@Test
	public void verifyRegistrationFunctionalityInShopSection(Method method) throws Exception{
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO, "Executing verifyRegistrationFunctionalityInShopSection test");
		IosHomePage homePage=new IosHomePage(_driver,testLog);
		IosMorePage morePage=homePage.clickOnMoreOption();
		morePage.validateMorePage();
		IosShopPage shopPage=morePage.clickOnShopOption();
		shopPage.clickOnRegister();
		shopPage.inputFirstName(config.getKey("FIRST_NAME"));
		shopPage.inputLastName(config.getKey("LAST_NAME"));
		shopPage.inputEmail(config.getKey("EMAIL"));
		shopPage.inputPassword(config.getKey("PASSWORD"));
		shopPage.clickOnCreate();
		Assert.assertTrue(shopPage.verifyLoginScreenAvailability());
		
		
	}
	
	@Test
	public void verifyCartAndCheckoutFunctionality(Method method) throws Exception{
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO, "Executing verifyCartAndCheckoutFunctionality test");
		IosHomePage homePage=new IosHomePage(_driver,testLog);
		IosMorePage morePage=homePage.clickOnMoreOption();
		morePage.validateMorePage();
		IosShopPage shopPage=morePage.clickOnShopOption();
		shopPage.inputShopItemToSearch(config.getKey("SHOPPING_ITEM"));
		
	}

}
