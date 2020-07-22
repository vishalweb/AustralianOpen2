package com.australianopen.android.locators;

import org.openqa.selenium.By;

public class PlayersPageAndroidLocators {
	
	public static final By PLAYERS_SEARCHBAR = By.xpath("//android.widget.EditText[@text='Find a player']");
	public static final By PLAYERS_FAVOURITESTAB = By.xpath("//android.widget.TextView[@text='Favourites']");
	public static final By PLAYERS_SELECTFAVPLAYER = By.xpath("//android.widget.ImageView");
	public static final By PLAYERS_FAVOURITESTAB_FAVPLAYER = By.xpath("(//android.widget.ImageView)[1]");
	
}
