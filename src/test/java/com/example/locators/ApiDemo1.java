package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;



public enum ApiDemo1 implements BaseElement {

	txtUsername(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_username_edit_text"),MobileBy.className("XCUIElementTypeTextField")),
	txtPassword(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_password_edit_text"),MobileBy.className("XCUIElementTypeSecureTextField")),
	btnLogin(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_login_text_view"),MobileBy.AccessibilityId("Login")),
	lstMainItem(MobileBy.xpath("//android.widget.TextView[@text='replaceit']"),null),
	lstHorizontalTabItem(MobileBy.xpath("//android.widget.TabWidget[@resource-id='android:id/tabs']"),null),
	tabHorizontalItem1(MobileBy.xpath("//android.widget.TextView[@text='Tab 4']"),null),
	tabHorizontalItem2(MobileBy.xpath("//android.widget.TextView[@text='Tab 1']"),null),
	tabHorizontalItem(MobileBy.xpath("//android.widget.TextView[@text='replaceit']"),null),
	editTextBox1(By.id("com.example.android.apis:id/edit0"),null),
	editTextBox2(By.id("com.example.android.apis:id/edit1"),null),
	dragItem1(By.id("io.appium.android.apis:id/drag_dot_1"),null),
	dragItem2(By.id("io.appium.android.apis:id/drag_dot_2"),null),
	dragItem3(By.id("io.appium.android.apis:id/drag_dot_3"),null),
	lstSpinner1(MobileBy.id("com.example.android.apis:id/spinner1"),null),
	lstSpinner2(MobileBy.id("com.example.android.apis:id/spinner2"),null),
	lstSpinnerPopup(MobileBy.xpath("//android.widget.CheckedTextView[@text='replaceit']"),null),
	textSpinnerView(MobileBy.xpath("//android.widget.TextView[@text='replaceit']"),null),
	loginPopupMessage1(null,MobileBy.AccessibilityId("Please enter Email/ Username")),
	loginPopupMessage2(null,MobileBy.AccessibilityId("Username/Password incorrect")),
	loginPopupOkButton(null,MobileBy.AccessibilityId("OK")),
	btnAllow(null,MobileBy.xpath("//XCUIElementTypeButton[@name=\\\"Allow\\\"]"));
	
	private static final Logger logger = Logger.getLogger(ApiDemo1.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	ApiDemo1(By aby,By iby) {
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
