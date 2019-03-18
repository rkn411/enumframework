package com.vsoft.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.elements.core.DriverFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class PageBase {

	public static Logger logger = Logger.getLogger(PageBase.class);
	public static ThreadLocal<AppiumDriver<MobileElement>> driver =  new ThreadLocal<>();
	private AppiumDriverLocalService appiumDriverService;
	public static ThreadLocal<String> platformName =  new ThreadLocal<>();

	public WebDriverWait wait;

	/**
	 * use this method to launch app according to the site.
	 * 
	 * @param browser
	 * @throws Exception
	 *
	 */
	//@Parameters("platform")
	public void openApplication(String platform) throws Exception {
		platformName.set(platform);
		try {
			driver.set(DriverFactory.getDriverFor(platform));
		} catch (Exception e) {
			logger.info("Exception Details: " + e.getMessage());
			closeApplication();
		}
	}

	/**
	 * use this method to get the locator.
	 * 
	 * @param by
	 *
	 */
	public static WebElement getElement(By by) {
		return driver.get().findElement(by);
	}

	 /**
	 * use this method to get the driver.
	 *
	 */
	 public static AppiumDriver<MobileElement> getDriver() // call this method to get the driver
	 {
	 return driver.get();
	 }

	/**
	 * use this method to get the java script driver.
	 *
	 */
	public static JavascriptExecutor getJSDriver() // call this method to get the javascriptexecutor
	{
		return (JavascriptExecutor) driver;
	}

	/**
	 * use this method to get the NG web driver.
	 *
	 */
	public static NgWebDriver getNGDriver() // call this method to get the ngwebdriver
	{
		return (new NgWebDriver(getJSDriver()));
	}

	// used to start appium server
	public boolean startAppiumServer() {
		if (appiumDriverService != null) {
			appiumDriverService.start();
			return appiumDriverService.isRunning();
		}
		return false;
	}

	// used to stop appium server
	public void stopAppiumServer() {
		if (appiumDriverService != null) {
			appiumDriverService.stop();
			System.out.println(" Stopped Appium Server");
		}
	}

	/**
	 * use this method to close the application.
	 *
	 */
	public void closeApplication() {
		driver.get().quit();
	}
}
