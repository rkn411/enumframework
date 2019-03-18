package com.tsd.tests;

import org.testng.annotations.Test;

import com.example.locators.Locators;
import com.vsoft.base.TestBase;

public class CalculatorTest extends TestBase{

	@Test
	public void addTwoNumbers() {
		Locators.digit1.click();
		Locators.add_id.click();
		Locators.digit2.click();
		Locators.equals_id.click();
	}
}
