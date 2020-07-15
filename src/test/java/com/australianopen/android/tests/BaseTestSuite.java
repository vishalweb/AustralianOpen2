package com.australianopen.android.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.australianopen.basesuite.BaseSuite;
import com.australianopen.locators.AndroidLocators;
import com.australianopen.utils.ConfigFileReader;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.Wait;

import bsh.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import org.openqa.selenium.html5.Location;

public class BaseTestSuite extends BaseSuite {

	public static final long IMPLICIT_WAIT = 15;
	public ConfigFileReader config = new ConfigFileReader();
	public AndroidDriver<WebElement> driver;
	private Logger log = LoggerHelper.getLogger(BaseTestSuite.class);

	@BeforeMethod
	public void setUpDriver() throws Exception {
		prepareSetupForAndroid();

	}

	@AfterMethod(alwaysRun = true)
	public void afterEveryTestEnds(ITestResult result, Method method) throws Exception {
			
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				String image = testLog.addScreenCapture(createScreenshot());
				testLog.log(LogStatus.PASS, result.getName(), method.getName() + image);
			} else if (result.getStatus() == ITestResult.FAILURE) {
				String image = testLog.addScreenCapture(createScreenshot());
				testLog.log(LogStatus.FAIL, result.getThrowable());
				testLog.log(LogStatus.FAIL, result.getName(), method.getName() + image);
			} else {
				testLog.log(LogStatus.SKIP, result.getName(), method.getName());
				testLog.log(LogStatus.FAIL, result.getThrowable());
			}
		} finally {
			extent.endTest(testLog);
			extent.flush();
			driver.quit();
		}
	}

	public AndroidDriver<WebElement> prepareSetupForAndroid() throws Exception {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", config.getKey("androidDevice"));
			dc.setCapability("platformVersion", config.getKey("androidPlatformVersion"));
			dc.setCapability("platformName", "Android");
			dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			dc.setCapability("autoAcceptAlerts", true);
			dc.setCapability("appPackage", config.getKey("::Pakage name goes here"));
			dc.setCapability("appActivity", config.getKey(":: Activity name goes here"));
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
			log.info("Initilizing the android driver");
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			log.info("Implicit wait applied on the driver: " + IMPLICIT_WAIT + " in Seconds");
		} catch (Exception e) {
			log.info("driver is not initilized");
		}
		return driver;
	}

	public String createScreenshot() throws Exception {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(config.getKey("screenshotLocation") + uuid + ".png"));
		} catch (IOException e) {
			testLog.log(LogStatus.INFO, "Error while generating screenshot:\n" + e.toString());
		}
		return "./Screenshots/" + uuid + ".png";
	}

	public void closeApp() {
		log.info("Closing the application");
		driver.closeApp();
	}

	public void openApp() {
		log.info("Launching the application");
		driver.launchApp();
	}
}
