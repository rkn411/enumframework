package com.vsoft.actions;

import static com.vsoft.automation.utilities.ExceptionUtil.getExceptionStackTrace;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.base.PageBase;
import com.vsoft.elements.core.BaseElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

/**
 * This class is a wrapper over Selenium Webdriver actions.
 * 
 */

public class AppiumWrapper extends PageBase {

	private static final Logger logger = Logger.getLogger(AppiumWrapper.class);

	private static long EXPLICIT_WAIT_TIME = ConfigProperties.EXPLICIT_WAIT_TIME;

	private static boolean HIGHLIGHT_ELEMENT;
	private static String mainWindowHandle = null;

	/**
	 * To verify particular element is present or not and return the status
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean isElementPresent(BaseElement eLocator) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			if (status = (!getDriver().findElements(by).isEmpty())) {
				logger.info("Element is present in the DOM.");
			} else {
				logger.info("Element is NOT present in the DOM.");
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait until element is present till explicit timeout
	 *
	 * @param eLocator
	 * @return isElementPresent
	 */
	public static boolean waitForElementToBePresent(BaseElement eLocator) {
		boolean isElementPresent = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(by));
			isElementPresent = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return isElementPresent;
	}

	/**
	 * To wait until element is visible till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return status
	 */
	public static boolean waitForElementToBeVisible(BaseElement eLocator, long timeOutInSeconds) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
			getDriver().findElement(by);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait until element is visible till explicit timeout
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean waitForElementToBeVisible(BaseElement eLocator) {
		return waitForElementToBeVisible(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element is clickable till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return status
	 */
	public static boolean waitForElementToBeClickable(BaseElement eLocator, long timeOutInSeconds) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
			getDriver().findElement(by);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait until element is clickable till explicit timeout
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean waitForElementToBeClickable(BaseElement eLocator) {
		return waitForElementToBeClickable(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element is invisible till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return status
	 */
	public static boolean waitForElementToBeInvisible(BaseElement eLocator, long timeOutInSeconds) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			status = new WebDriverWait(getDriver(), timeOutInSeconds)
					.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait until element is invisible till explicit timeout
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean waitForElementToBeInvisible(BaseElement eLocator) {
		return waitForElementToBeInvisible(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element is displayed till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return status
	 */
	public static boolean isDisplayed(BaseElement eLocator, long timeOutInSeconds) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			status = new WebDriverWait(getDriver(), timeOutInSeconds)
					.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
		} catch (NoSuchElementException ignored) {
			status = false;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait until element is displayed till explicit timeout
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean isDisplayed(BaseElement eLocator) {
		return isDisplayed(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element is enabled till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return isEnabled
	 */
	public static boolean isEnabled(BaseElement eLocator, long timeOutInSeconds) {
		boolean isEnabled = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			isEnabled = new WebDriverWait(getDriver(), timeOutInSeconds)
					.until(ExpectedConditions.elementToBeClickable(by)).isEnabled();
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return isEnabled;
	}

	/**
	 * To wait until element is enabled till explicit timeout
	 *
	 * @param eLocator
	 * @return isEnabled
	 */
	public static boolean isEnabled(BaseElement eLocator) {
		return isEnabled(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element is selected till given timeout
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return isSelected
	 */
	public static boolean isSelected(BaseElement eLocator, long timeOutInSeconds) {
		boolean isSelected = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			MobileElement we = (MobileElement) new WebDriverWait(getDriver(), timeOutInSeconds)
					.until(ExpectedConditions.elementToBeClickable(by));
			isSelected = we.isSelected();
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
		} catch (NoSuchElementException ignored) {
			isSelected = false;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return isSelected;
	}

	/**
	 * To wait until element is selected till explicit timeout
	 *
	 * @param eLocator
	 * @return isSelected
	 */
	public static boolean isSelected(BaseElement eLocator) {
		return isSelected(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To click on the element using javascript
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean jsClick(BaseElement eLocator) {
		boolean status = false;
		By by = eLocator.getLocator(platformName.get());
		try {
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			MobileElement element = getDriver().findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
			executor.executeScript("arguments[0].click();", element);
			status = true;
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To click on the element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean click(BaseElement eLocator) {
		boolean status = false;
		By by = eLocator.getLocator(platformName.get());
		try {
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			MobileElement element = getDriver().findElement(by);
			try {
				element.click();
			} catch (WebDriverException e) {
				if (e.getMessage().contains("element would receive the click")) {
					waitUnconditionallyFor(3);
					element.click();
				} else {
					throw e;
				}
			}
			status = true;
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To clear and enter text in to the element
	 *
	 * @param eLocator
	 * @param valueToType
	 * @return status
	 */
	public static boolean type(BaseElement eLocator, String valueToType) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			getElement(by).clear();
			getElement(by).sendKeys(valueToType);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To append text to the element
	 *
	 * @param eLocator
	 * @param valueToAppend
	 * @return status
	 */
	public static boolean appendText(BaseElement eLocator, String valueToAppend) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			getElement(by).sendKeys(valueToAppend);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To clear the element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean clear(BaseElement eLocator) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			getDriver().findElement(by).clear();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To get text of the element
	 *
	 * @param eLocator
	 * @return text
	 */
	public static String getText(BaseElement eLocator) {
		String text = null;
		try {
			By by = eLocator.getLocator(platformName.get());
			MobileElement we = (MobileElement) new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			text = we.getText();
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (null == text) {
			logger.info("No innertext.");
			return text;
		} else {
			return text;
		}
	}

	/**
	 * To get list of the element
	 *
	 * @param eLocator
	 * @return text
	 */
	public static List<MobileElement> getElementList(BaseElement eLocator) {
		List<MobileElement> list = null;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			list = driver.get().findElements(by);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (null == list) {
			logger.info("No list presnet for element.");
			return list;
		} else {
			return list;
		}
	}

	/**
	 * To verify text of the element
	 *
	 * @param eLocator
	 * @param expectedText
	 * @return status
	 */
	public static boolean verifyText(BaseElement eLocator, String expectedText) {
		boolean status = false;
		String actualText = null;
		try {
			actualText = getText(eLocator);
			if (actualText != null) {
				status = (actualText.equals(expectedText)) ? true : false;
			} else {
				logger.info("Could not get the actual text.");
			}
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To highlight the element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean highlight(BaseElement eLocator) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			MobileElement we = getDriver().findElement(by);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px groove yellow'", we);
			status = true;
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To remove styling for highlighted element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean removeHighlight(BaseElement eLocator) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			MobileElement we = getDriver().findElement(by);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border=''", we);
			status = true;
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To wait unconditionally for given time
	 *
	 * @param seconds
	 */
	public static void waitUnconditionallyFor(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * To verify item existence inside a list
	 *
	 * @param seconds
	 * @param valueToVerify
	 * @return status
	 */
	public static boolean verifyItemInsideList(BaseElement eLocator, String valueToVerify) {
		boolean itemStatus = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT) {
				if (highlight(eLocator)) {
					removeHighlight(eLocator);
				}
			}
			Select select = new Select(getElement(by));
			List<WebElement> list = select.getOptions();
			for (WebElement ele : list) {
				if (ele.getText().equalsIgnoreCase(valueToVerify)) {
					itemStatus = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return itemStatus;
	}

	/**
	 * To select the dropdown value by given text
	 *
	 * @param seconds
	 * @param valueToSelect
	 * @return status
	 */
	public static boolean selectByVisibleText(BaseElement eLocator, String valueToSelect) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT) {
				if (highlight(eLocator)) {
					removeHighlight(eLocator);
				}
			}
			new Select(getDriver().findElement(by)).selectByVisibleText(valueToSelect);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To move to the element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean moveToElement(BaseElement eLocator) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			Actions actions = new Actions(getDriver());
			MobileElement element = (MobileElement) new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			actions.moveToElement(element).build().perform();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To scroll to the element based on text
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean scrollIntoView(BaseElement eLocator, String text) {
		boolean status = false;
		int counter = 1;
		try {
			By by = eLocator.getLocator(platformName.get());
			while (!status && counter < 8) {
				try {
					logger.error("scrolling " + counter + " time for " + text);
					getDriver().findElement(MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
									+ text + "\"))"));
					new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
							.until(ExpectedConditions.visibilityOfElementLocated(by));
					status = true;
				} catch (Exception e) {
					counter++;
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To press on one element and release on another element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean pressAndReleaseElement(BaseElement from, BaseElement to) {
		boolean status = false;
		try {
			By fromby = from.getLocator(platformName.get());
			By toby = to.getLocator(platformName.get());

			TouchAction touchAction = new TouchAction(driver.get());
			touchAction.press(ElementOption.element(getDriver().findElement(fromby)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(ElementOption.element(getDriver().findElement(toby))).release().perform();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To press on one element and release on another element
	 *
	 * @param from
	 * @param to
	 * @return status
	 */
	public static boolean longPressAndReleaseElement(BaseElement from, BaseElement to) {
		boolean status = false;
		try {
			By fromby = from.getLocator(platformName.get());
			By toby = to.getLocator(platformName.get());

			TouchAction touchAction = new TouchAction(driver.get());
			touchAction.longPress(ElementOption.element(getDriver().findElement(fromby)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(ElementOption.element(getDriver().findElement(toby))).release().perform();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To scroll to the element by passing scrollable element by using java script
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean scrollToElementByJs(BaseElement eLocator, String text) {
		boolean status = false;
		int counter = 1;

		try {
			By by = eLocator.getLocator(platformName.get());
			while (!status && counter < 4) {
				try {
					logger.error("scrolling " + counter + " time for " + text);
					JavascriptExecutor js = (JavascriptExecutor) driver.get();
					HashMap<String, Object> scrollObject = new HashMap<>();
					// scrollObject.put("predicateString", "value == '" + text + "'");
					// scrollObject.put("direction", "down");
					scrollObject.put("name", text);
					js.executeScript("mobile: scroll", scrollObject);
					new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
							.until(ExpectedConditions.visibilityOfElementLocated(by));
					status = true;
				} catch (Exception e) {
					logger.error("Exception : " + getExceptionStackTrace(e));
					counter++;
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To scroll to the element up or down
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean scrollUpOrDownElementIos(BaseElement eLocator, String move) {
		boolean status = false;
		int counter = 1;
		try {
			By by = eLocator.getLocator(platformName.get());
			while (!status && counter < 4) {
				try {
					new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
							.until(ExpectedConditions.visibilityOfElementLocated(by));
					status = true;
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver.get();
					HashMap<String, Object> scrollObject = new HashMap<>();
					scrollObject.put("direction", move);
					js.executeScript("mobile: scroll", scrollObject);
					status = false;
				}
				counter++;
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To hide keyboard
	 *
	 * @return status
	 */
	public static Boolean hideKeyboard() {
		boolean status = false;
		try {
			getDriver().hideKeyboard();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To return current window
	 *
	 * @return mainWindowHandle
	 */
	public static String saveCurrentWindowHandle() {
		String mainWindowHandle = null;
		try {
			mainWindowHandle = getDriver().getWindowHandle();
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (null == mainWindowHandle) {
			logger.info("Not able to get current window handle.");
			return mainWindowHandle;
		} else {
			return mainWindowHandle;
		}
	}

	/**
	 * To switch to new window
	 *
	 * @return newWindowHandle
	 */
	public static String switchToNewWindow() {
		String newWindowHandle = null;
		try {
			Set<String> windows = getDriver().getWindowHandles();
			for (String window : windows) {
				if (!window.equals(mainWindowHandle)) {
					newWindowHandle = window;
					getDriver().switchTo().window(window);
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (null == newWindowHandle) {
			logger.info("Not able to get new window.");
			return newWindowHandle;
		} else {
			return newWindowHandle;
		}
	}

	/**
	 * To switch to frame using frame name
	 * 
	 * @param frameName
	 * @return status
	 */
	public static Boolean switchToFrame(String frameName) {
		boolean status = false;
		try {
			getDriver().switchTo().defaultContent();
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME)
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			getDriver().switchTo().frame(frameName);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To switch to frame by using child
	 * 
	 * @param childElmLocator
	 * @return boolean
	 */
	public static boolean switchToFrameByUsingChild(By childElmLocator) {
		try {
			List<MobileElement> frameElems = getAllFrames();
			for (int frmIndex = 0; frmIndex < frameElems.size(); frmIndex++) {
				getDriver().switchTo().frame(frameElems.get(frmIndex));
				if (getDriver().findElements(childElmLocator).size() > 0) {
					return true;
				} else if (getAllFrames().size() > 0) {
					if (switchToChildFrameByChild(childElmLocator)) {
						return true;
					} else {
						getDriver().switchTo().defaultContent();
					}
				} else {
					getDriver().switchTo().defaultContent();
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return false;
	}

	/**
	 * to get all frame elements that are created using frame and iframe tags
	 * 
	 * @return totalFrms
	 */
	private static List<MobileElement> getAllFrames() {
		List<MobileElement> totalFrms = new ArrayList<MobileElement>();
		try {
			List<MobileElement> iFrmLst = getDriver().findElements(By.tagName("iframe"));
			List<MobileElement> frmLst = getDriver().findElements(By.tagName("frame"));
			totalFrms.addAll(iFrmLst);
			totalFrms.addAll(frmLst);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return totalFrms;
	}

	/**
	 * To switch to child frame by using child
	 * 
	 * @param childElmLocator
	 * @return boolean
	 */
	private static boolean switchToChildFrameByChild(By childElmLocator) {
		try {
			List<MobileElement> cFrameElems = getAllFrames();
			int cFrmIndex;
			for (cFrmIndex = 0; cFrmIndex < cFrameElems.size(); cFrmIndex++) {
				getDriver().switchTo().frame(cFrameElems.get(cFrmIndex));
				if (getDriver().findElements(childElmLocator).size() > 0) {
					return true;
				} else if (getAllFrames().size() > 0) {
					if (switchToChildFrameByChild(childElmLocator)) {
						return true;
					} else {
						getDriver().switchTo().parentFrame();
					}
				} else {
					getDriver().switchTo().parentFrame();
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return false;
	}

	/**
	 * To switch to main window
	 *
	 * @return status
	 */
	public static Boolean switchToMainWindow() {
		boolean status = false;
		try {
			getDriver().switchTo().window(mainWindowHandle);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To switch to window by using window title
	 *
	 * @param wndTitle
	 * @return wndFound
	 */
	public static boolean switchToWindowByTitle(String wndTitle) {
		Set<String> strWndHandles = getDriver().getWindowHandles();
		boolean wndFound = false;
		try {
			for (String wndHandle : strWndHandles) {
				getDriver().switchTo().window(wndHandle);
				if (getDriver().getTitle().equalsIgnoreCase(wndTitle)) {
					wndFound = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return wndFound;
	}

	/**
	 * To switch to window by using child element
	 *
	 * @param cElmlocator
	 * @return wndFound
	 */
	public static boolean switchToWindowByChildElement(By cElmlocator) {
		Set<String> strWndHandles = getDriver().getWindowHandles();
		boolean wndFound = false;
		try {
			for (String wndHandle : strWndHandles) {
				getDriver().switchTo().window(wndHandle);
				if (getDriver().findElements(cElmlocator).size() > 0) {
					wndFound = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return wndFound;
	}

	/**
	 * To get current url
	 *
	 * @return text
	 */
	public static String getCurrentURL() {
		String text = null;
		try {
			text = getDriver().getCurrentUrl();
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (null == text) {
			logger.info("Not able to get url.");
			return text;
		} else {
			return text;
		}
	}

	/**
	 * To close current window
	 *
	 * @return status
	 */
	public static Boolean closeCurrentWindow() {
		boolean status = false;
		try {
			getDriver().close();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To accept the alert
	 *
	 */
	public static void acceptIfAlertIsPresent() {
		Alert alert = null;
		try {
			alert = new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (alert != null) {
			getDriver().switchTo().alert().accept();
		} else {
			logger.info("Alert missing.");
		}
	}

	/**
	 * To get attribute of an element
	 *
	 * @param eLocator
	 * @param attributeName
	 * @return text
	 */
	public static String getAttribute(BaseElement eLocator, String attributeName) {
		String text = "fail";
		try {
			By by = eLocator.getLocator(platformName.get());
			text = getDriver().findElement(by).getAttribute(attributeName);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return text;
	}

	/**
	 * To navigate to the new url
	 * 
	 * @param url
	 * @return status
	 */
	public static Boolean get(String url) {
		boolean status = false;
		try {
			getDriver().get(url);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To close all window
	 *
	 * @return status
	 */
	public static Boolean closeAllWindows() {
		boolean status = false;
		try {
			getDriver().quit();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To maximize the window
	 *
	 * @return status
	 */
	public static Boolean maximizeWindow() {
		boolean status = false;
		try {
			getDriver().manage().window().maximize();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To refresh the page
	 *
	 * @return status
	 */
	public static Boolean refresh() {
		boolean status = false;
		try {
			getDriver().navigate().refresh();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To dismiss the Alert
	 *
	 * @return status
	 */
	public static Boolean dismissAlert() {
		boolean status = false;
		Alert alert = null;
		try {
			alert = new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (alert != null) {
			getDriver().switchTo().alert().dismiss();
			status = true;
		} else {
			logger.info("Alert missing.");
		}
		return status;
	}

	/**
	 * To get the Alert message
	 *
	 * @return alertText
	 */
	public static String getAlertText() {
		String alertText = null;
		Alert alert = null;
		try {
			alert = new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		if (alert != null) {
			alertText = getDriver().switchTo().alert().getText();
			return alertText;
		} else {
			logger.info("Alert missing.");
			return alertText;
		}
	}

	/**
	 * To get the current selected value from the select list
	 *
	 * @param eLocator
	 * @return String
	 */
	public static String getSelectedDropdownValue(BaseElement eLocator) {
		String getValue = null;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(by));
			if (HIGHLIGHT_ELEMENT) {
				if (highlight(eLocator)) {
					removeHighlight(eLocator);
				}
			}
			Select select = new Select(getElement(by));
			MobileElement element = (MobileElement) select.getFirstSelectedOption();
			getValue = element.getText();
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return getValue;
	}

	/**
	 * To wait until element not exist till explicit time
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean isElementNotExist(BaseElement eLocator) {
		return isElementNotExist(eLocator, EXPLICIT_WAIT_TIME);
	}

	/**
	 * To wait until element not exist till given time
	 *
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return status
	 */
	public static boolean isElementNotExist(BaseElement eLocator, long timeOutInSeconds) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), timeOutInSeconds).until(ExpectedConditions.numberOfElementsToBe(by, 0));
			status = true;
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To click on android back button
	 *
	 */
	public static Boolean pressAndroidBackButton() {
		boolean status = false;
		try {
			((AndroidDriver<MobileElement>) driver.get()).pressKeyCode(AndroidKeyCode.BACK);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To click on android home button
	 *
	 */
	public static Boolean pressAndroidHomeButton() {
		boolean status = false;
		try {
			((AndroidDriver<MobileElement>) driver.get()).pressKeyCode(AndroidKeyCode.HOME);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To enter text to the picker wheel element
	 *
	 * @param eLocator
	 * @param valueToEnter
	 * @return status
	 */
	public static boolean pickerWheelEnterText(BaseElement eLocator, String valueToEnter) {
		boolean status = false;
		try {
			By by = eLocator.getLocator(platformName.get());
			new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(by));
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			getElement(by).sendKeys(valueToEnter);
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To press on one element and release on another element
	 *
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 * @return status
	 */
	public static boolean pressAndReleaseElementUsingCoordinates(int xStart, int yStart, int xEnd, int yEnd) {
		boolean status = false;
		try {
			TouchAction touchAction = new TouchAction(driver.get());
			touchAction.press(ElementOption.point(xStart, yStart)).moveTo(PointOption.point(xEnd, yEnd)).release()
					.perform();
			status = true;
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

	/**
	 * To click on the switch element
	 *
	 * @param eLocator
	 * @return status
	 */
	public static boolean switchOrSteppersClick(BaseElement eLocator) {
		boolean status = false;
		By by = eLocator.getLocator(platformName.get());
		try {
			if (HIGHLIGHT_ELEMENT)
				highlight(eLocator);
			MobileElement element = getDriver().findElement(by);
			element.click();
			status = true;
		} catch (Exception e) {
			status = false;
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
		return status;
	}

}