package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;



public enum APSRTC implements BaseElement {

	txtUsername(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_username_edit_text"),null),
	txtPassword(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_password_edit_text"),null),
	btnLogin(By.id("com.vsoft.servicenow.vportal.debug:id/login_screen_login_text_view"),null),
	
	iconMainBookItem(MobileBy.xpath("//android.widget.TextView[@text='Book Ticket']"),null),
	iconSubBookItem(MobileBy.xpath("//android.view.View[@content-desc='Book Your Ticket as Guest']"),null),
	editFrom(MobileBy.xpath("//android.widget.EditText[@content-desc='From']"),null),
	editBoarding(MobileBy.xpath("//android.widget.EditText[@content-desc='Enter bording place name or city and select place from the dropdown list.']"),null),
	editTo(MobileBy.xpath("//android.widget.EditText[@content-desc='To']"),null),
	editDropping(MobileBy.xpath("//android.widget.EditText[@content-desc='Enter alighting place name or city and select place from the dropdown list.']"),null),
	editSelection(MobileBy.xpath("//android.view.View[@content-desc='replaceit']"),null),
	
	editDeparts(MobileBy.xpath("//android.widget.EditText[@content-desc='Depart On']"),null),
	btnCheckAvailability(MobileBy.xpath("//android.widget.Button[@content-desc='Check Availability Search']"),null),
	btnDateSelection(MobileBy.xpath("//android.view.View[@content-desc='replaceit']"),null),
	textBusElement(MobileBy.xpath("//android.view.View[@content-desc='replaceit']"),null),
	selectBusSeats(MobileBy.xpath("//android.view.View[@content-desc='replaceit']/following-sibling::android.view.View[@content-desc='Select Seats'][1]"),null),
	
	spinnerDropping(MobileBy.xpath("//android.widget.Spinner[@content-desc='Select One']"),null),
	selectDropping(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text,'replaceit')]"),null),
	
	btnShowLayout(MobileBy.xpath("//android.widget.Button[@content-desc='Show layout'"),null),
	
	tabHorizontalItem2(MobileBy.xpath("//android.widget.TextView[@text='Tab 1']"),null),
	tabHorizontalItem(MobileBy.xpath("//android.widget.TextView[@text='replaceit']"),null),
	editTextBox1(By.id("com.example.android.apis:id/edit0"),null),
	editTextBox2(By.id("com.example.android.apis:id/edit1"),null),
	btnAllow(null,MobileBy.xpath("//XCUIElementTypeButton[@name=\\\"Allow\\\"]"));
	
	private static final Logger logger = Logger.getLogger(APSRTC.class);
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	APSRTC(By aby,By iby) {
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
