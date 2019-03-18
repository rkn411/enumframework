package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.vsoft.elements.core.BaseElement;


public enum Locators implements BaseElement {

	digit0(By.id("com.android.calculator2:id/digit_0"),null),
	digit1(By.id("com.android.calculator2:id/digit_1"),null),
    digit2(By.id("com.android.calculator2:id/digit_2"),null),
    digit3(By.id("com.android.calculator2:id/digit_3"),null),
	digit4(By.id("com.android.calculator2:id/digit_4"),null),
	digit5(By.id("com.android.calculator2:id/digit_5"),null),
	digit6(By.id("com.android.calculator2:id/digit_6"),null),
	digit7(By.id("com.android.calculator2:id/digit_7"),null),
	digit8(By.id("com.android.calculator2:id/digit_8"),null),
	digit9(By.id("com.android.calculator2:id/digit_9"),null),
	decimal_id(By.id("com.android.calculator2:id/dec_point"),null),
	equals_id(By.id("com.android.calculator2:id/eq"),null),
	delete_id(By.id("com.android.calculator2:id/del"),null),
	divide_id(By.id("com.android.calculator2:id/op_div"),null),
	multiple_id(By.id("com.android.calculator2:id/op_mu"),null),
	subtract_id(By.id("com.android.calculator2:id/op_sub"),null),
	add_id(By.id("com.android.calculator2:id/op_add"),null),
	result_id(By.id("com.android.calculator2:id/formula"),null);

	private static final Logger logger = Logger.getLogger(Locators.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	Locators(By aby,By iby) {
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
