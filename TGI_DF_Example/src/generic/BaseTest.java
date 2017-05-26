package generic;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;
import util.ConfigurationManager;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.*;
//import org.apache.log4j.xml.DOMConfigurator;

public class BaseTest {

	private static final String EXECUTION_MODE_WEBDRIVER = "local";
	private static final String EXECUTION_MODE_GRID = "remote";
	private static final String BROWSER_CHROME = "Chrome";
	private static final String BROWSER_FIREFOX = "Firefox";
	private static final String BROWSER_IE = "IE";
	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	private static final String CHROME_DRIVER_VALUE = "chromedriver.exe";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String APP_URL = "appUrl";

	protected AndroidDriver driver;
	private DesiredCapabilities capability;
	private LoginPage loginPage;
	private static String executionMode;
	private static String browser;
	private static String username;
	private static String password;
	private static String appUrl;
	private static String gridIP;

	protected Logger logger = Logger.getLogger(getClass().getName());

	@BeforeTest
	public void loadConfigurationValues(ITestContext context) {
		//DOMConfigurator.configure("src/Log4j/log4j.xml");
		ConfigurationManager.createManager(context);

		executionMode = ConfigurationManager.returnExecutionMode();
		browser = ConfigurationManager.returnBrowser();
		gridIP = ConfigurationManager.returnGridIP();

		username = ConfigurationManager.returnConfigurationValue(USERNAME);
		password = ConfigurationManager.returnConfigurationValue(PASSWORD);
		appUrl = ConfigurationManager.returnConfigurationValue(APP_URL);

	}

	private void setupEnvironment() {
		try {
			File rootPath = new File(System.getProperty("user.dir"));
			File appDir = new File(rootPath, "src/resources");
			File app = new File(appDir, "Test_QA-0.0.42.1.apk");
			// -----------------------
			//File imagePath = new File(System.getProperty("user.dir"));
			//File imageDir = new File(imagePath, "src/images/");
		//[] imagesList = imageDir.listFiles();

			// byte[] fileContent = Files.readAllBytes(image.toPath());

			// -------------------------
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("fullReset", "true");
			desiredCapabilities.setCapability("platformName", "Android");
			//desiredCapabilities.setCapability("platformVersion", "7.0");
			desiredCapabilities.setCapability("deviceName", "04157df4f45d8a2e"); // 192.168.57.101:5555
																		// Emulator
																		// genymotion
			//desiredCapabilities.setCapability("browserName", "Android");
			desiredCapabilities.setCapability("app", app.getAbsolutePath());
			desiredCapabilities.setCapability("appPackage", "org.benetech.secureapp.CECBJGGGJ.BEGBHJBBAFFEE");
			//desiredCapabilities.setCapability("appActivity","org.benetech.secureapp.activities.CacheWordHandlerActivity");
			desiredCapabilities.setCapability("appWaitActivity","org.benetech.secureapp.activities.CreatePassphraseActivity");

			String url = "http://127.0.0.1:4723/wd/hub";

			driver = new AndroidDriver(new URL(url), desiredCapabilities);
			//for (File f : imagesList) {
		
			//	byte[] fileContent = Files.readAllBytes(f.toPath());
				
			///	driver.pushFile("/sdcard/Download/" + f.getName(), fileContent);
				
				// /sdcard/Download/
				// /storage/emulated/0/Download/
		//	}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@BeforeMethod
	public void setUp() {
		try {
			setupEnvironment();

		} catch (Exception e) {
		}
	}

	@AfterSuite
	public void closeDriver() {
		if (driver != null) {
			driver.quit();

		}
	}

	protected void assertTrueCondition(boolean condition) {
		Assert.assertTrue(condition);
	}

}
