package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;

public enum LoginPage implements BaseElement {

	txtUsername(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_username_edit_text"),MobileBy.className("XCUIElementTypeTextField")),
	txtPassword(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_password_edit_text"),MobileBy.className("XCUIElementTypeSecureTextField")),
	btnLogin(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_login_text_view"),MobileBy.AccessibilityId("Login")),
	loginPopupTitle(null,MobileBy.xpath("//XCUIElementTypeStaticText[@value='V-Portal']")),
	loginPopupMessage1(null,MobileBy.AccessibilityId("Please enter Email/ Username")),
	loginPopupMessage2(null,MobileBy.AccessibilityId("Username/Password incorrect")),
	loginPopupOkButton(null,MobileBy.AccessibilityId("OK")),
	btnAllow(null,MobileBy.xpath("//XCUIElementTypeButton[@name=\\\"Allow\\\"]"));
	
private static final Logger logger = Logger.getLogger(LoginPage.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	LoginPage(By aby,By iby) {
		this.aby = aby;
		this.oldAndriod = aby;
		this.iosby = iby;
		this.oldIOS = iby;
	}


	public By getLocator(String os) {
		if(os.equals("ios"))
			return iosby;
		else
			return aby;
	}
	public String getName() {
		return name();
	}

	
	public By getAndroidLocator() {
		return aby;
	}
	
	public By getIOSLocator() {
		return iosby;
	}

	
	public void resetLocator() {
		this.aby = this.oldAndriod;
		logger.info("Old android is " + this.oldAndriod);
		this.iosby = this.oldIOS;
		logger.info("Old IOS is " + this.oldIOS);
		//return this;
	}

	public BaseElement setLocator(String platformName,By by) {
		if(platformName.equals("android"))
		{
		this.aby = by;
		logger.info("set android is " + this.aby);
		}
		else
		{
		this.iosby = by;
		logger.info("set ios is " + this.iosby);
		}
		return this;
	}	
}
