package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;

public enum HomePage implements BaseElement {

	homeIcon(By.id("com.vsoft.servicenow.vportal.debug:id/nav_back"),MobileBy.xpath("//XCUIElementTypeNavigationBar[@name=\\\"V-Portal\\\"]/XCUIElementTypeButton[1]")),
	btnLogout(By.id("com.vsoft.servicenow.vportal.debug:id/home_screen_logout_image_view"),MobileBy.AccessibilityId("logout")),
	reportIncident(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][1]"),MobileBy.xpath("//XCUIElementTypeCell[2]//XCUIElementTypeButton")),
	orderServices(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][2]"),MobileBy.xpath("//XCUIElementTypeCell[3]//XCUIElementTypeButton")),
	myIncidents(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][3]"),MobileBy.xpath("//XCUIElementTypeCell[4]//XCUIElementTypeButton")),
	myRequests(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][4]"),MobileBy.xpath("//XCUIElementTypeCell[5]//XCUIElementTypeButton")),
	createHrCase(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][5]"),MobileBy.xpath("//XCUIElementTypeCell[6]//XCUIElementTypeButton")),
	viewHrCase(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][6]"),MobileBy.xpath("//XCUIElementTypeCell[7]//XCUIElementTypeButton")),
	chat(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][7]"),MobileBy.xpath("//XCUIElementTypeCell[1]//XCUIElementTypeButton")),
	reports(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][8]"),null),
	notifications(null,MobileBy.xpath("//XCUIElementTypeCell[8]//XCUIElementTypeButton")),
	approvals(By.xpath("//android.widget.RelativeLayout[@resource-id='com.vsoft.servicenow.vportal.debug:id/card_view'][7]"),MobileBy.xpath("//XCUIElementTypeCell[9]//XCUIElementTypeButton")),
	btnOk(By.id("android:id/button1"),MobileBy.xpath("////XCUIElementTypeButton[@name='Yes']")),
	homepageTitle(By.xpath("//android.widget.TextView[@text=\"VERA\"]"),MobileBy.xpath("//*[name()='XCUIElementTypeOther' or name()='XCUIElementTypeStaticText'][@name=\"V-Portal\"]"));

	private static final Logger logger = Logger.getLogger(HomePage.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	HomePage(By aby,By iby) {
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
