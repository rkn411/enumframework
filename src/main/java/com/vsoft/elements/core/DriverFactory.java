package com.vsoft.elements.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.base.PageBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory extends PageBase {

	public static DesiredCapabilities caps = new DesiredCapabilities();

	public static AppiumDriver<MobileElement> getDriverFor(String platform) throws Exception {

		switch (platform.toLowerCase()) {
		case "ios":
			return iosSetup("Vsoft_iPhone6Plus_11.2.6", "11.2", "com.hycite.docucite.development", "a4d86522602a25e704503b10e0f2a43f23e02ec6");
		case "android":
			return androidSetup(ConfigProperties.ANDROIDUDID, ConfigProperties.ANDROIDVERSION);
		default:
			System.out.println("No Valid OS found with the name");
			return null;
		}
	}

	/**
	 * This method to launch android and execute
	 *
	 * @param deviceId
	 * @param androidversion
	 * @throws InterruptedException
	 * @return successful launch android device/emulator
	 */
	public static AppiumDriver<MobileElement> androidSetup(String deviceId, String androidversion)
			throws MalformedURLException {
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("deviceName", deviceId);
		caps.setCapability("platformName", "android");
		caps.setCapability("platformVersion", androidversion);
		caps.setCapability("autoDismissAlerts", true);
		caps.setCapability("app", System.getProperty("user.dir") + "\\Resources\\DocuCite_devBuild.apk");
//		caps.setCapability("appPackage", "com.example.android.apis");
//		caps.setCapability("appActivity", "com.example.android.apis.ApiDemos");
//		caps.setCapability("appPackage", "com.apsrtc.online");
//		caps.setCapability("appActivity", "com.abhibus.app.apsrtc.DashBoardActivity");
		caps.setCapability("appPackage", "com.hycite.docucite");
		caps.setCapability("appActivity", "com.hycite.docucite.splash.screen.view.SplashActivity");
		return new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	/**
	 * This method to launch ios and execute
	 *
	 * @param device
	 * @param platformversion
	 * @param bundleid
	 * @return successful launch ios real device/simulator
	 * @throws InterruptedException
	 * 
	 */
	public static IOSDriver<MobileElement> iosSetup(String device, String platformversion, String bundleid, String udid)
			throws Exception {
		caps.setCapability("deviceName", device);
		caps.setCapability("platformName", "iOS");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformVersion", platformversion);
		caps.setCapability("autoAcceptAlerts", true);
		caps.setCapability("udid", udid);
		caps.setCapability("bundleId", bundleid);
		caps.setCapability("app", System.getProperty("user.dir") + "/Resources/DocuCite.ipa");
		return new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}
}