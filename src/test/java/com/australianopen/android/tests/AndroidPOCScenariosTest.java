package com.australianopen.android.tests;

import org.apache.log4j.Logger;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.australianopen.android.pages.ConditionsOfUsePage;
import com.australianopen.android.pages.MorePage;
import com.australianopen.android.pages.PlayerInformationPage;
import com.australianopen.android.pages.PlayersPage;
import com.australianopen.android.pages.WelcomePage;
import com.australianopen.android.pages.WhatsOnPage;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.LogStatus;

public class AndroidPOCScenariosTest extends BaseTestSuite {
		
//	private Logger log=LoggerHelper.getLogger(AndroidPOCScenariosTest.class);
	
	public static final String EMAIL_IS_REQUIRED_MSG = "Email is required.";
	public static final String CONTACTPHONE_IS_REQUIRED_MSG = "Contact Phone is required.";
	public static final String STATE_IS_REQUIRED_MSG = "State is required.";
	public static final String ENQUIRYTYPE_IS_REQUIRED_MSG = "Enquiry type is required.";
	public static final String MESSAGE_IS_REQUIRED_MSG = "Message is required.";
	
	@Test
	public void TC001_verifyFavouriteFunctionality(Method method) throws Exception{
		testLog=extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO,"Executing verifyFavouriteFunctionality test");
		WelcomePage welcomePage = new WelcomePage(driver,testLog);
		WhatsOnPage whatsOnPage = welcomePage.clickOnSkipAllButton();	
		MorePage morePage = whatsOnPage.clickOnMoreButton();
		morePage.verifyMorePageTitleVisibility();
		PlayersPage playersPage = morePage.clickOnPlayersOption();
		playersPage.enterPlayerNameInSearchBar(config.getKey("playerName"));
	    PlayerInformationPage playerInformationPage = playersPage.selectFavouritePlayers();
		playerInformationPage.clickOnFavouriteButton();
		playerInformationPage.clickOnBackButton();
		playersPage.clickOnFavouritesTab();
		Assert.assertTrue(playersPage.verifyFavoritePlayer());
		playersPage.selectFavouritePlayers();
		playerInformationPage.clickOnFavouriteButton();
		playerInformationPage.clickOnBackButton();
		playersPage.clickOnFavouritesTab();
		Assert.assertTrue(playersPage.verifyFavoriteSectionIsBlank());	
	}
	
	@Test
	public void verifyTheContactFunctionalityInConditionsOfUse_TC002(Method method) throws Exception{
		testLog = extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
		testLog.log(LogStatus.INFO,"Executing verifyTheContactFunctionalityInConditionsOfUse test");
		WelcomePage welcomePage = new WelcomePage(driver,testLog);
		WhatsOnPage whatsOnPage = welcomePage.clickOnSkipAllButton();	
		MorePage morePage = whatsOnPage.clickOnMoreButton();
		morePage.verifyMorePageTitleVisibility();
		ConditionsOfUsePage conditionsOfUsePage =morePage.clickOnConditionsOfUse();
		conditionsOfUsePage.clickOnMenuButton();
		conditionsOfUsePage.clickOnContactButton();
		conditionsOfUsePage.enterFirstName(config.getKey("firstName"));
		conditionsOfUsePage.enterLastName(config.getKey("lastName"));
		conditionsOfUsePage.clickOnPrivacyCheckbox();
		conditionsOfUsePage.clickOnSubmitButton();
		Assert.assertEquals(conditionsOfUsePage.verifyEmailRequiredMessage(), EMAIL_IS_REQUIRED_MSG);
		Assert.assertEquals(conditionsOfUsePage.verifyContactPhoneRequiredMessage(), CONTACTPHONE_IS_REQUIRED_MSG);
		Assert.assertEquals(conditionsOfUsePage.verifyStateRequiredMessage(), STATE_IS_REQUIRED_MSG);
		Assert.assertEquals(conditionsOfUsePage.verifyEnquiryTypeRequiredMessage(), ENQUIRYTYPE_IS_REQUIRED_MSG);
		Assert.assertEquals(conditionsOfUsePage.verifyMessageRequiredMessage(), MESSAGE_IS_REQUIRED_MSG);
	}
}
