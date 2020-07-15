package com.australianopen.basesuite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.testng.annotations.BeforeSuite;
import com.australianopen.utils.ConfigFileReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseSuite {
	public  static String timeStamp = new SimpleDateFormat("MM-dd.HH.mm.ss").format(new Date());
	public  static ExtentReports extent;
	public  static ExtentTest testLog;
	public static ConfigFileReader config;
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		config = new ConfigFileReader();
		timeStamp = new SimpleDateFormat("MM-dd.HH.mm.ss").format(new Date());
		extent = new ExtentReports(config.getKey("extentReport") + timeStamp + ".html", true);
		
	}

	public static String getRandomString(int n) throws Exception {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static int generateRandomNumber() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + (r.nextInt(10000)));
	}
	
	public static String getResourcePath(String path) {
    String basePath = System.getProperty("user.dir");
    System.out.println(basePath +"/"+ path);
	return basePath +"/"+ path;
}

}
