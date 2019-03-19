package com.vsoft.actions;

import java.util.List;

import com.vsoft.elements.core.BaseElement;

import io.appium.java_client.MobileElement;

public interface ElementActions {

	// Waiting Methods
	void waitForElementToBeVisible(BaseElement eLocator, long timeOutInSeconds);

	void waitForElementToBeVisible(BaseElement eLocator);

	void waitForElementToBeClickable(BaseElement eLocator, long timeOutInSeconds);

	void waitForElementToBeClickable(BaseElement eLocator);

	void waitForElementToBeInvisible(BaseElement eLocator, long timeOutInSeconds);

	void waitForElementToBeInvisible(BaseElement eLocator);

	void waitForElementToBePresent(BaseElement eLocator);

	// Get Element Status Method
	Boolean isDisplayed(BaseElement eLocator, long timeOutInSeconds);

	Boolean isDisplayed(BaseElement eLocator);

	Boolean isElementPresent(BaseElement eLocator);

	Boolean isEnabled(BaseElement eLocator, long timeOutInSeconds);

	Boolean isEnabled(BaseElement eLocator);

	Boolean isSelected(BaseElement eLocator, long timeOutInSeconds);

	Boolean isSelected(BaseElement eLocator);

	void verifyNotSelected(BaseElement eLocator, long timeOutInSeconds);

	void verifyNotSelected(BaseElement eLocator);

	void verifySelected(BaseElement eLocator, long timeOutInSeconds);

	void verifySelected(BaseElement eLocator);

	void verifyEnabled(BaseElement eLocator, long timeOutInSeconds);

	void verifyEnabled(BaseElement eLocator);

	void verifyDisplayed(BaseElement eLocator, long timeOutInSeconds);

	void verifyDisplayed(BaseElement eLocator);

	void verifyElementPresent(BaseElement eLocator);

	// Element Actions
	void click(BaseElement eLocator) throws TestFailedException;

	void switchOrSteppersClick(BaseElement eLocator);

	void jsClick(BaseElement eLocator);

	void type(BaseElement eLocator, String valueToType) throws TestFailedException;

	void appendText(BaseElement eLocator, String valueToAppend) throws TestFailedException;

	void clear(BaseElement eLocator) throws TestFailedException;

	void selectByVisibleText(BaseElement eLocator, String valueToSelect) throws TestFailedException;

	List<MobileElement> getElementList(BaseElement eLocator);

	Boolean verifyItemInsideList(BaseElement eLocator, String valueToVerify);

	void verifyElementNotExist(BaseElement eLocator);

	void verifyElementNotExist(BaseElement eLocator, long timeOutInSeconds);

	// get data from elements
	String getText(BaseElement eLocator);

	String getAttribute(BaseElement eLocator, String attributeName);

	// Verification Methods
	Boolean verifyText(BaseElement eLocator, String expectedText);

	Boolean verifyAttributeValue(BaseElement eLocator, String attributeName, String expectedValue);

	// Make Element Visible
	void moveToElement(BaseElement eLocator);

	void scrollIntoView(BaseElement eLocator, String text);

	void highlight(BaseElement eLocator);
}
