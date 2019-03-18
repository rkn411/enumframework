package com.vsoft.elements.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vsoft.actions.PageActions;
import com.vsoft.actions.AppiumReportWrapper;
import com.vsoft.actions.DeviceActions;
import com.vsoft.base.PageBase;

import io.appium.java_client.MobileBy;

public interface BaseElement {
	
	public By getLocator(String platforName);

	public By getAndroidLocator();

	public By getIOSLocator();

	public String getName();
	
	public void resetLocator();
	
	//public BaseElement resetIOSLocator();
	
	public BaseElement setLocator(String platformName,By by);
	
	//public BaseElement setAndroidLocator(By by);

	public default void updateLocator(String platformName, String... updatedVal) {
		resetLocator();
		String strLoc = getLocator(platformName).toString();
		String[] arrLoc = strLoc.split(":", 2);
		String locatorType = arrLoc[0];
		locatorType = locatorType.substring(3);
		String locatorValue = arrLoc[1].trim();

		for (String lVal : updatedVal)
			locatorValue = locatorValue.replaceFirst("replaceit", lVal);

		switch (locatorType.toLowerCase()) {
		case "id":
			setLocator(platformName, MobileBy.AccessibilityId(locatorValue));
			break;
		case "xpath":
			setLocator(platformName, MobileBy.xpath(locatorValue));
			break;
		case "cssselector":
			setLocator(platformName, MobileBy.cssSelector(locatorValue));
			break;
		case "name":
			setLocator(platformName, MobileBy.name(locatorValue));
			break;
		case "tagname":
			setLocator(platformName, MobileBy.tagName(locatorValue));
			break;
		case "classname":
			setLocator(platformName, MobileBy.className(locatorValue));
			break;
		case "linktext":
			setLocator(platformName, MobileBy.linkText(locatorValue));
			break;
		case "partiallinktext":
			setLocator(platformName, MobileBy.partialLinkText(locatorValue));
			break;
		default:
			System.out.println("Update Locator Failed");
			break;
		}
	}
	
//	public default void updateIOSLocator(String... updatedVal) {
//		resetIOSLocator();
//		String strLoc = getIOSLocator().toString();
//		String[] arrLoc = strLoc.split(":", 2);
//		String locatorType = arrLoc[0];
//		locatorType = locatorType.substring(3);
//		String locatorValue = arrLoc[1].trim();
//
//		for (String lVal : updatedVal)
//			locatorValue = locatorValue.replaceFirst("replaceit", lVal);
//
//		switch (locatorType.toLowerCase()) {
//		case "id":
//			setIOSLocator(MobileBy.AccessibilityId(locatorValue));
//			break;
//		case "xpath":
//			setIOSLocator(MobileBy.xpath(locatorValue));
//			break;
//		case "cssselector":
//			setIOSLocator(MobileBy.cssSelector(locatorValue));
//			break;
//		case "name":
//			setIOSLocator(MobileBy.name(locatorValue));
//			break;
//		case "tagname":
//			setIOSLocator(MobileBy.tagName(locatorValue));
//			break;
//		case "classname":
//			setIOSLocator(MobileBy.className(locatorValue));
//			break;
//		case "linktext":
//			setIOSLocator(MobileBy.linkText(locatorValue));
//			break;
//		case "partiallinktext":
//			setIOSLocator(MobileBy.partialLinkText(locatorValue));
//			break;
//		default:
//			System.out.println("Update Locator Failed");
//			break;
//		}
//	}
	

	AppiumReportWrapper allActions = new AppiumReportWrapper();
	PageActions pageActions = allActions;
	DeviceActions deviceActions = allActions;

	public static PageActions getPage() {
		return allActions;
	}

	public default void click() {
		allActions.click(this);
	}

	public default void enterText(String valToEnter) {
		allActions.type(this, valToEnter);
	}

	public default void cleartext() {
		allActions.clear(this);
	}

	public default String getElementText() {
		String text = allActions.getText(this);
		return text;
	}

	public default Boolean verifyElementText(String expctedtext) {
		return allActions.verifyText(this, expctedtext);
	}

	public default void highlightElement() {
		allActions.highlight(this);
	}

	public default void waitForSomeTime(long seconds) {
		allActions.waitUnconditionallyFor(seconds);
	}

	public default void selectByText(String valueToSelect) {
		allActions.selectByVisibleText(this, valueToSelect);
	}

	public default void moveToElement() {
		allActions.moveToElement(this);
	}

	public default void scrollIntoElement(String valuetoscroll) {
		allActions.scrollIntoView(this,valuetoscroll);
	}
	
	public default void scrollToElementByJs(String valuetoscroll) {
		allActions.scrollToElementByJs(this,valuetoscroll);
	}
	
	public default void scrollUpOrDownElementIos(String move) {
		allActions.scrollUpOrDownElementIos(this,move);
	}
	
	public default void pressAndReleaseElement(BaseElement element) {
		allActions.pressAndReleaseElement(this,element);
	}

	public default void longPressAndReleaseElement(BaseElement element) {
		allActions.longPressAndReleaseElement(this,element);
	}
	
	public default void checkElementPresence() {
		allActions.isElementPresent(this);
	}

	public default void waitForElementToBePresent() {
		allActions.waitForElementToBePresent(this);
	}

	public default void waitForElementToBeVisible() {
		allActions.waitForElementToBeVisible(this);
	}

	public default void waitForElementToBeVisible(long timeOutInSeconds) {
		allActions.waitForElementToBeVisible(this, timeOutInSeconds);
	}

	public default void waitForElementToBeClickable() {
		allActions.waitForElementToBeClickable(this);
	}

	public default void waitForElementToBeClickable(long timeOutInSeconds) {
		allActions.waitForElementToBeClickable(this, timeOutInSeconds);
	}

	public default void waitForElementToBeInvisible() {
		allActions.waitForElementToBeInvisible(this);
	}

	public default void waitForElementToBeInvisible(long timeOutInSeconds) {
		allActions.waitForElementToBeInvisible(this, timeOutInSeconds);
	}

	public default Boolean isDisplayed() {
		return allActions.isDisplayed(this);
	}

	public default Boolean isDisplayed(long timeOutInSeconds) {
		return allActions.isDisplayed(this, timeOutInSeconds);
	}

	public default Boolean isEnabled() {
		return allActions.isEnabled(this);
	}

	public default Boolean isEnabled(long timeOutInSeconds) {
		return allActions.isEnabled(this, timeOutInSeconds);
	}

	public default Boolean isSelected() {
		return allActions.isSelected(this);
	}

	public default Boolean isSelected(long timeOutInSeconds) {
		return allActions.isSelected(this, timeOutInSeconds);
	}

	public default String getAttributeValue(String attributeName) {
		return allActions.getAttribute(this, attributeName);
	}

	public default List<WebElement> getElementList() {
		return allActions.getElementList(this);
	}

	public default Boolean verifyItemInsideList(String valueToVerify) {
		return allActions.verifyItemInsideList(this, valueToVerify);
	}

	public default void jsclick() {
		allActions.jsClick(this);
	}

	public default Boolean verifyAttributeValue(String attributeName, String attributeValue) {
		return allActions.verifyAttributeValue(this, attributeName, attributeValue);
	}

	public default void appendText(String valueToAppend) {
		allActions.appendText(this, valueToAppend);
	}

	public default String getSelectedDropdownValue() {
		return allActions.getSelectedDropdownValue(this);
	}

	public default void verifyElementNotExist() {
		allActions.verifyElementNotExist(this);
	}

	public default void verifyElementNotExist(long timeOutInSeconds) {
		allActions.verifyElementNotExist(this, timeOutInSeconds);
	}

	public default void verifyNotSelected() {
		allActions.verifyNotSelected(this);
	}

	public default void verifyNotSelected(long timeOutInSeconds) {
		allActions.verifyNotSelected(this, timeOutInSeconds);
	}

	public default void verifySelected() {
		allActions.verifySelected(this);
	}

	public default void verifySelected(long timeOutInSeconds) {
		allActions.verifySelected(this, timeOutInSeconds);
	}

	public default void verifyEnabled() {
		allActions.verifyEnabled(this);
	}

	public default void verifyEnabled(long timeOutInSeconds) {
		allActions.verifyEnabled(this, timeOutInSeconds);
	}

	public default void verifyDisplayed() {
		allActions.verifyDisplayed(this);
	}

	public default void verifyDisplayed(long timeOutInSeconds) {
		allActions.verifyDisplayed(this, timeOutInSeconds);
	}

	public default void verifyElementPresent(long timeOutInSeconds) {
		allActions.verifyElementPresent(this);
	}
	
	public default void pickerWheelEnterText(String valToEnter) {
		allActions.pickerWheelEnterText(this, valToEnter);
	}
	
	public default void switchOrSteppersClick() {
		allActions.switchOrSteppersClick(this);
	}
}
