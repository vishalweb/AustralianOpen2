package com.australianopen.ios.locators;

import org.openqa.selenium.By;

public class IosPlayersPageLocators {
	
	public static final By IOSPLAYERS_FINDAPLAYER=By.xpath("//XCUIElementTypeTextField[@value='Find a player']");
	public static final By IOSPLAYERS_SEARCHEDPLAYER=By.xpath("//XCUIElementTypeOther[contains(@name,'FullPlayerComponent')]");
	public static final By IOSPLAYERS_FAVORITES_OPTION=By.xpath("//XCUIElementTypeButton[contains(@name,'Favourites')]");

}
