package com.australianopen.ios.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.australianopen.basesuite.BaseSuite;
import com.australianopen.utils.ConfigFileReader;
import com.australianopen.utils.LoggerHelper;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IosBaseTestSuite extends BaseSuite {
	public static final long IMPLICIT_WAIT = 15;
	public ConfigFileReader config = new ConfigFileReader();
	public IOSDriver<WebElement> _driver;
	private Logger log = LoggerHelper.getLogger(IosBaseTestSuite.class);

	@BeforeMethod
	public void setUpDriver() throws Exception {
		prepareSetupforIos();
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
		//	_driver.quit();
	}

	}

	public String createScreenshot() throws Exception {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(config.getKey("screenshotLocation") + uuid + ".png"));
		} catch (IOException e) {
			testLog.log(LogStatus.INFO, "Error while generating screenshot:\n" + e.toString());
		}
		return "./Screenshots/" + uuid + ".png";
	}

	public IOSDriver<WebElement> prepareSetupforIos() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {
			log.info("Executing Desired Capabilities");
			capabilities.setCapability("platformName", config.getKey("platformname"));
			capabilities.setCapability("platformVersion", config.getKey("platformversion"));
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("bundleId", config.getKey("bundleId"));
			capabilities.setCapability("device", "iPhone");
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("deviceName", config.getKey("devicename"));
			capabilities.setCapability("udid", config.getKey("udid"));
			_driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			log.info("Initializing the iOS Driver");
			_driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			log.info("Implicit wait applied on the driver: " + IMPLICIT_WAIT + " in Seconds");
		} catch (Exception e) {
			log.info("Driver is not Initialized");
		}
		return _driver;

	}

	public void openApp() {
		_driver.resetApp();
	}

	public void closeApp() {
		_driver.closeApp();
	}
	
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) _driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) _driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		js.executeScript("mobile: scroll", scrollObject);
	}

	
	public void scrollUpWithJavaScript(String text){
		JavascriptExecutor js = (JavascriptExecutor) _driver;
        HashMap<Object, Object> scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + text + "'");
        scrollObject.put("direction", "up");
             js.executeScript("mobile: scroll", scrollObject);
	}

}
