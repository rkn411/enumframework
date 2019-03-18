package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;



public enum PopUpPO implements BaseElement {

	btnCancel(By.xpath("//android.widget.Button[@text='Cancel']"),MobileBy.xpath("//XCUIElementTypeButton[@name='Cancel']")),
	btnYes(By.xpath("//android.widget.Button[@text='Yes']"),MobileBy.xpath("//XCUIElementTypeButton[@name='Yes']")),
	btnOk(By.id("android:id/button1"),MobileBy.AccessibilityId("OK"));

private static final Logger logger = Logger.getLogger(PopUpPO.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	PopUpPO(By aby,By iby) {
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
