package com.vsoft.automation.utilities;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;
import static com.vsoft.core.extreport.ExtentTestManager.passStep;

import java.util.List;

import org.apache.log4j.Logger;

import com.vsoft.actions.AppiumWrapper;
import com.vsoft.core.report.ActionResult;
import com.vsoft.elements.core.BaseElement;

public class ElementsUtil {

	public static Logger logger = Logger.getLogger(ElementsUtil.class);

	/**
	 * use this method to verify list of elements presence task.
	 * 
	 * @param listOfElements
	 *
	 */
	public static void verifyListOfElementsPresence(List<BaseElement> listOfElements) {
		for (BaseElement eLocator : listOfElements) {
			ActionResult actionResult = null;
			try {
				logger.info("checking for presence of the element: '" + ElementsUtil.getElementName(eLocator.getName())
						+ "' ...");
				boolean result = AppiumWrapper.isElementPresent(eLocator);
				actionResult = new ActionResult(result);
				actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
				actionResult.setElementName(eLocator.getName());

				if (actionResult.getStatus() == true) {
					actionResult.setDescription(
							"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
					logger.info(actionResult.getDescription());
					passStep(actionResult);
				} else {
					actionResult.setDescription("Failed to find that the element: '"
							+ ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
					logger.error(actionResult.getDescription());
					failStep(actionResult, false);
				}
			} catch (Exception e) {
				logger.info("Exception Details: " + e.getMessage());
			}
		}
	}

	/**
	 * use this method to verify list of elements enabled.
	 * 
	 * @param listOfElements
	 *
	 */
	public static void verifyListOfElementsEnabled(List<BaseElement> listOfElements) {
		for (BaseElement eLocator : listOfElements) {
			ActionResult actionResult = null;
			try {
				logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
						+ "' is enabled...");
				boolean result = AppiumWrapper.isEnabled(eLocator);
				actionResult = new ActionResult(result);
				actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
				actionResult.setElementName(eLocator.getName());

				if (actionResult.getStatus() == true) {
					actionResult.setDescription(
							"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is enabled.");
					logger.info(actionResult.getDescription());
					passStep(actionResult);
				} else {
					actionResult.setDescription("Failed to find that the element: '"
							+ ElementsUtil.getElementName(eLocator.getName()) + "' is enabled.");
					logger.error(actionResult.getDescription());
					failStep(actionResult, false);
				}
			} catch (Exception e) {
				logger.info("Exception Details: " + e.getMessage());
			}
		}
	}

	/**
	 * use this method to verify list of elements disabled.
	 * 
	 * @param listOfElements
	 * @param attributeName
	 * @param expectedValue
	 *
	 */
	public static void verifyListOfElementsDisabled(List<BaseElement> listOfElements, String attributeName,
			String expectedValue) {
		for (BaseElement eLocator : listOfElements) {
			String result = null;
			ActionResult actionResult = null;
			try {
				logger.info("verifying is the element '" + ElementsUtil.getElementName(eLocator.getName())
						+ "' is disabled...");
				result = AppiumWrapper.getAttribute(eLocator, attributeName);
				if (result.equals("fail")) {
					actionResult = new ActionResult(false);
				} else
					actionResult = new ActionResult(true);
				actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
				actionResult.setElementName(eLocator.getName());

				if (result.equalsIgnoreCase(expectedValue)) {
					actionResult.setDescription(
							"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is disabled.");
					logger.info(actionResult.getDescription());
					passStep(actionResult);
				} else {
					actionResult.setDescription("Failed to verify that the element: '"
							+ ElementsUtil.getElementName(eLocator.getName()) + "' is disabled.");
					logger.error(actionResult.getDescription());
					failStep(actionResult);
				}
			} catch (Exception e) {
				logger.info("Exception Details: " + e.getMessage());
			}
		}
	}

	public static String getElementName(String elementName) {
		int position = -1;
		try {
			for (int i = 0; i < elementName.length(); i++) {
				if (Character.isUpperCase(elementName.charAt(i))) {
					{
						position = i;
						break;
					}
				}
			}
			String preElementName = elementName.substring(0, position);
			String postElementName = elementName.substring(position);
			switch (preElementName) {
			case "btn":
				elementName = postElementName + " button";
				break;
			case "txt":
				elementName = postElementName + " textbox";
				break;
			case "lnk":
				elementName = postElementName + " link";
				break;
			default:
				break;
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + ExceptionUtil.getExceptionStackTrace(e));
		}
		return elementName;
	}
}
