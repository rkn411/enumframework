package com.vsoft.actions;

import static com.vsoft.automation.utilities.ExceptionUtil.getExceptionStackTrace;
import static com.vsoft.core.extreport.ExtentTestManager.failStep;
import static com.vsoft.core.extreport.ExtentTestManager.passStep;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.vsoft.automation.utilities.ElementsUtil;
import com.vsoft.core.report.ActionResult;
import com.vsoft.elements.core.BaseElement;

public class AppiumReportWrapper implements PageActions, ElementActions,DeviceActions {

	public static Logger logger = Logger.getLogger(AppiumReportWrapper.class);

	/**
	 * use this method do wait for the element with specified time, to be visible
	 * and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @throws Exception
	 *
	 */

	public void waitForElementToBeVisible(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for visibility of the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' ...");
			boolean result = AppiumWrapper.waitForElementToBeVisible(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is visible.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is visible.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method do wait for the element to be visible and do necessary report
	 * task.
	 * 
	 * @param eLocator
	 * @throws Exception
	 *
	 */

	public void waitForElementToBeVisible(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for visibility of the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' ...");
			boolean result = AppiumWrapper.waitForElementToBeVisible(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is visible.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is visible.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to check for the element present and do necessary report
	 * task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isElementPresent(BaseElement eLocator) {
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
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
				logger.error(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to check for the element to be present and do necessary
	 * report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void waitForElementToBePresent(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("waiting for presence of the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' ...");
			boolean result = AppiumWrapper.waitForElementToBePresent(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to be click-able with sometime
	 * specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void waitForElementToBeClickable(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' to be clickable...");
			boolean result = AppiumWrapper.waitForElementToBeClickable(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is clickable.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is clickable.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to wait for the element to be click-able and do necessary
	 * report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void waitForElementToBeClickable(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' to be clickable...");
			boolean result = AppiumWrapper.waitForElementToBeClickable(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is clickable.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is clickable.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to be invisible with sometime
	 * specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */
	public void waitForElementToBeInvisible(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' to be invisible...");
			boolean result = AppiumWrapper.waitForElementToBeInvisible(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is invisible.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not invisible.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to be invisible and do necessary
	 * report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void waitForElementToBeInvisible(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("Waiting for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' to be invisible...");
			boolean result = AppiumWrapper.waitForElementToBeInvisible(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is invisible.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not invisible.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to wait for the element to check element is displayed with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isDisplayed(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is displayed...");
			boolean result = AppiumWrapper.isDisplayed(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is displayed.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not displayed.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to wait for the element to check element is displayed and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isDisplayed(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is displayed...");
			boolean result = AppiumWrapper.isDisplayed(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is displayed.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not displayed.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to wait for the element to check element is enabled with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isEnabled(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is enabled...");
			boolean result = AppiumWrapper.isEnabled(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is enabled.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not enabled.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to wait for the element to check element is enabled and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */
	public Boolean isEnabled(BaseElement eLocator) {
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
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not enabled.");
				logger.error(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to wait for the element to check element is slected with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isSelected(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is selected...");
			boolean result = AppiumWrapper.isSelected(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to wait for the element to check element is selected and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean isSelected(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is selected...");
			boolean result = AppiumWrapper.isSelected(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to click on the element and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void click(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.click(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Clicked on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Failed to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to click on the element using java script code and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void jsClick(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.jsClick(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Clicked on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Failed to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to clear and enter text and do necessary report task.
	 * 
	 * @param eLocator
	 * @param valueToType
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void type(BaseElement eLocator, String valueToType) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to enter text for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			boolean result = AppiumWrapper.type(eLocator, valueToType);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Entered text for the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to enter text for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to append text and do necessary report task.
	 * 
	 * @param eLocator
	 * @param valueToAppend
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void appendText(BaseElement eLocator, String valueToAppend) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to append text for the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			boolean result = AppiumWrapper.appendText(eLocator, valueToAppend);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Appened text for the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to append text for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to clear and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void clear(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to clear the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.clear(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Cleared the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Failed to clear the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	public String getText(BaseElement eLocator) {
		ActionResult actionResult = null;
		String rTxt = null;
		try {
			logger.info(
					"trying to get text of the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			rTxt = AppiumWrapper.getText(eLocator);
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Retreived text of the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to retreive text of element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return rTxt;
	}

	/**
	 * use this method to verify text and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean verifyText(BaseElement eLocator, String expectedText) {
		ActionResult actionResult = null;

		try {
			logger.info("trying to verify text of the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			boolean result = AppiumWrapper.verifyText(eLocator, expectedText);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Verified text of the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Actual and expected text of element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + " not matching.");
				logger.info(actionResult.getDescription());
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return actionResult.getStatus();
	}

	/**
	 * use this method to get element list and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */
	public List<WebElement> getElementList(BaseElement eLocator) {
		ActionResult actionResult = null;
		List<WebElement> list = null;
		try {
			logger.info("trying to get the element list for : '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			list = AppiumWrapper.getElementList(eLocator);
			if (list == null)
				actionResult = new ActionResult(false);
			else
				actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());
			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Retreived the list for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to retreive the list for element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return list;
	}

	/**
	 * use this method to highlight the element and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void highlight(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to highlight the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.highlight(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Highlighted the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to highlight the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to select the element by visible text and do necessary report
	 * task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void selectByVisibleText(BaseElement eLocator, String valueToSelect) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to select the value for the element: '"
					+ ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.selectByVisibleText(eLocator, valueToSelect);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Selected the value for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to select the value for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to verify item existence inside a list and do necessary
	 * report task.
	 * 
	 * @param eLocator
	 * @param valueToVerify
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public Boolean verifyItemInsideList(BaseElement eLocator, String valueToVerify) {
		ActionResult actionResult = null;
		Boolean result = false;
		try {
			logger.info("trying to verify element inside the list: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			result = AppiumWrapper.verifyItemInsideList(eLocator, valueToVerify);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Successfully found the value inside the list: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the value inside the list: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return result;
	}

	/**
	 * use this method to move to the element and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void moveToElement(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to move to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.moveToElement(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Moved to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to move to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to scroll to the element and do necessary report task for andriod specific.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void scrollIntoView(BaseElement eLocator,String text) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to scroll to the element: '" + ElementsUtil.getElementName(text) + "'...");
			boolean result = AppiumWrapper.scrollIntoView(eLocator,text);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(text);

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Scrolled to the element: '" + ElementsUtil.getElementName(text) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to scroll to the element: '" + ElementsUtil.getElementName(text) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to scroll to the element and do necessary report task for andriod specific.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void scrollToElementByJs(BaseElement eLocator,String text) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to scroll to the element: '" + ElementsUtil.getElementName(text) + "'...");
			boolean result = AppiumWrapper.scrollToElementByJs(eLocator,text);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(text);

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Scrolled to the element: '" + ElementsUtil.getElementName(text) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to scroll to the element: '" + ElementsUtil.getElementName(text) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to scroll to the element and do necessary report task for andriod specific.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void scrollUpOrDownElementIos(BaseElement eLocator,String move) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to scroll to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.scrollUpOrDownElementIos(eLocator,move);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Scrolled to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to scroll to the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to press and release on another element for scrolling type and do necessary report task for andriod specific.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void pressAndReleaseElement(BaseElement from,BaseElement to) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to press on element: '" + ElementsUtil.getElementName(from.getName()) + "'...");
			boolean result = AppiumWrapper.pressAndReleaseElement(from,to);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(from.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"released to the element: '" + ElementsUtil.getElementName(to.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to release to the element: '" + ElementsUtil.getElementName(to.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to press and release on another element for scrolling type and do necessary report task for andriod specific.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void longPressAndReleaseElement(BaseElement from,BaseElement to) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to press on element: '" + ElementsUtil.getElementName(from.getName()) + "'...");
			boolean result = AppiumWrapper.longPressAndReleaseElement(from,to);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(from.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"released to the element: '" + ElementsUtil.getElementName(to.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription(
						"Failed to release to the element: '" + ElementsUtil.getElementName(to.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	

	/**
	 * use this method to get the attribute of the element and do necessary report
	 * task.
	 * 
	 * @param eLocator
	 * @param attributeName
	 * @return actionResult
	 * @throws Exception
	 *
	 */
	public String getAttribute(BaseElement eLocator, String attributeName) {
		String result = null;
		ActionResult actionResult = null;
		try {
			logger.info("trying to get the attribute value to the element: '"
					+ ElementsUtil.getElementName(eLocator.getName()) + "'...");
			result = AppiumWrapper.getAttribute(eLocator, attributeName);
			if (result.equals("fail")) {
				actionResult = new ActionResult(false);
			} else
				actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Retreived the attribute value for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to get the attribute for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

		return result;
	}

	/**
	 * use this method to verify the attribute of the element and do necessary
	 * report task.
	 * 
	 * @param eLocator
	 * @param attributeName
	 * @param expectedValue
	 * @return Boolean
	 * @throws Exception
	 *
	 */
	public Boolean verifyAttributeValue(BaseElement eLocator, String attributeName, String expectedValue) {
		String result = null;
		ActionResult actionResult = null;
		try {
			logger.info("trying to verify value to the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			result = AppiumWrapper.getAttribute(eLocator, attributeName);
			if (result.equals("fail")) {
				actionResult = new ActionResult(false);
			} else
				actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (result.equalsIgnoreCase(expectedValue)) {
				actionResult.setDescription("Verified the attribute value for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to verify the attribute value for the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

		return result.equalsIgnoreCase(expectedValue);
	}

	/**
	 * use this method to launch the application and do necessary report task.
	 * 
	 * @param url
	 * @throws Exception
	 *
	 */
	public void get(String url) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to open the url: '" + url + "'...");
			boolean result = AppiumWrapper.get(url);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Opened the url: '" + url + "'.");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to open the url: '" + url + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to get the current url and do necessary report task.
	 * 
	 * @return url
	 * @throws Exception
	 *
	 */
	public String getCurrentURL() {
		String url = null;
		ActionResult actionResult = null;
		try {
			logger.info("trying to get the current url:...");
			url = AppiumWrapper.getCurrentURL();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Retreived the url");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to get the url");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

		return url;
	}

	/**
	 * use this method to get the current window handle and do necessary report
	 * task.
	 * 
	 * @return window handle
	 * @throws Exception
	 *
	 */
	public String saveCurrentWindowHandle() {
		String windowhandle = null;
		ActionResult actionResult = null;
		try {
			logger.info("trying to get the current Window Handle:...");
			windowhandle = AppiumWrapper.saveCurrentWindowHandle();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Successfully get the Window Handle");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to get the Window Handle");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return windowhandle;
	}

	/**
	 * use this method to switch to new window handle and do necessary report task.
	 * 
	 * @return window handle
	 * @throws Exception
	 *
	 */
	public String switchToNewWindow() {
		String windowhandle = null;
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to new  window handle:...");
			windowhandle = AppiumWrapper.switchToNewWindow();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to new window handle");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to switch to new window handle");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return windowhandle;
	}

	/**
	 * use this method to switch to main window handle and do necessary report task.
	 *
	 * @throws Exception
	 *
	 */
	public void switchToMainWindow() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to main  window handle:...");
			Boolean result = AppiumWrapper.switchToMainWindow();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to main window handle");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to switch to main window handle");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to switch to new window based on name and do necessary report
	 * task.
	 * 
	 * @param wndTitle
	 * @throws Exception
	 *
	 */
	public void switchToWindowByTitle(String wndTitle) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to new window:...");
			Boolean result = AppiumWrapper.switchToFrame(wndTitle);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to new window");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to switch to new window");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to switch to new window based on child element and do
	 * necessary report task.
	 * 
	 * @param eChildelement
	 * @throws Exception
	 *
	 */
	public void switchToWindowByChildElement(BaseElement eChildelement) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to new  window  by using child element:...");
			AppiumWrapper.acceptIfAlertIsPresent();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to new window");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to switch to new window");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to maximize window handle and do necessary report task.
	 *
	 * @throws Exception
	 *
	 */
	public void maximizeWindow() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to maximize the window:...");
			Boolean result = AppiumWrapper.maximizeWindow();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Maximized window");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to maximize window");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to refresh window handle and do necessary report task.
	 *
	 * @throws Exception
	 *
	 */
	public void refresh() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to refresh the window:...");
			Boolean result = AppiumWrapper.refresh();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Refreshed the  window");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to refresh window");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to refresh window handle and do necessary report task.
	 *
	 * @throws Exception
	 *
	 */
	public void closeCurrentWindow() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to close the current window:...");
			Boolean result = AppiumWrapper.closeCurrentWindow();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Closed the current window");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to close current window");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to close all windows and do necessary report task.
	 *
	 * @throws Exception
	 *
	 */
	public void closeAllWindows() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to close all window:...");
			Boolean result = AppiumWrapper.closeAllWindows();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Closed all the current windows");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to close all current windows");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to switch to new frame based on name and do necessary report
	 * task.
	 * 
	 * @param frameName
	 * @throws Exception
	 *
	 */
	public void switchToFrame(String frameName) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to new frame:...");
			Boolean result = AppiumWrapper.switchToFrame(frameName);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to new frame");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to  switche to new frame");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to switch to new frame based on child element and do
	 * necessary report task.
	 * 
	 * @param eChildLocator
	 * @throws Exception
	 *
	 */
	public void switchToFrameByUsingChild(BaseElement eChildLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to switch to alert by using child element:...");
			AppiumWrapper.acceptIfAlertIsPresent();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Switched to child element");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to switch to child element");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to accept the alert if it is present and do necessary report
	 * task.
	 *
	 * @throws Exception
	 *
	 */
	public void acceptIfAlertIsPresent() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to accept the alert:...");
			AppiumWrapper.acceptIfAlertIsPresent();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Accepted the alert");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to accept the alert");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

	/**
	 * use this method to get alert message and do necessary report task.
	 * 
	 * @throws Exception
	 *
	 */
	public String getAlertText() {
		ActionResult actionResult = null;
		String alertMessage = null;
		try {
			logger.info("trying to get the alert message:...");
			alertMessage = AppiumWrapper.getAlertText();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Retreivied the alert message");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to get the alert message");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return alertMessage;
	}

	/**
	 * use this method to dismiss alert message and do necessary report task.
	 * 
	 * @throws Exception
	 *
	 */
	public void dismissAlert() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to dismiss the alert:...");
			AppiumWrapper.dismissAlert();
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Dismissed the alert");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to dismiss the alert");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * To wait unconditionally for given time
	 *
	 * @param seconds
	 */
	public void waitUnconditionallyFor(long seconds) {
		try {
			AppiumWrapper.waitUnconditionallyFor(seconds);
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method current selected value from the select list
	 * 
	 * @param eLocator
	 * @return String
	 *
	 */
	public String getSelectedDropdownValue(BaseElement eLocator) {
		ActionResult actionResult = null;
		String value = null;
		try {
			logger.info("Waiting for to retrive selected value for the element: '"
					+ ElementsUtil.getElementName(eLocator.getName()) + "' ...");
			value = AppiumWrapper.getSelectedDropdownValue(eLocator);
			actionResult = new ActionResult(true);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());
			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Retreived the selected value of the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()));
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to retrieve the selected value of the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()));
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		return value;
	}

	/**
	 * use this method to verify element not exist
	 * 
	 * @param eLocator
	 *
	 */
	public void verifyElementNotExist(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' not exist ...");
			boolean result = AppiumWrapper.isElementNotExist(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' not exist.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' exist");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to verify element not exist
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 *
	 */
	public void verifyElementNotExist(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' not exist ...");
			boolean result = AppiumWrapper.isElementNotExist(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' not exist.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' exist");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is not selected with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyNotSelected(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected...");
			boolean result = AppiumWrapper.isSelected(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == false) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is not selected and
	 * do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyNotSelected(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected...");
			boolean result = AppiumWrapper.isSelected(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == false) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is selected with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifySelected(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected...");
			boolean result = AppiumWrapper.isSelected(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is selected and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifySelected(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"verifying element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected...");
			boolean result = AppiumWrapper.isSelected(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is selected.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not selected.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is enabled with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyEnabled(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is enabled...");
			boolean result = AppiumWrapper.isEnabled(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is enabled.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not enabled.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is enabled and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */
	public void verifyEnabled(BaseElement eLocator) {
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
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not enabled.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is displayed with
	 * sometime specified and do necessary report task.
	 * 
	 * @param eLocator
	 * @param timeOutInSeconds
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyDisplayed(BaseElement eLocator, long timeOutInSeconds) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is displayed...");
			boolean result = AppiumWrapper.isDisplayed(eLocator, timeOutInSeconds);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is displayed.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not displayed.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to wait for the element to check element is displayed and do
	 * necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyDisplayed(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("verifying is the element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "' is displayed...");
			boolean result = AppiumWrapper.isDisplayed(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is displayed.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Element: '" + ElementsUtil.getElementName(eLocator.getName()) + "' is not displayed.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to check for the element present and do necessary report
	 * task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void verifyElementPresent(BaseElement eLocator) {
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
				actionResult.setDescription("Failed to find the element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "' is present.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	@Override
	public void pressKeyCode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void longPressKeyCode() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * use this method to hide keyboard
	 *
	 */
	public void hideKeyboard() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to hide the keyboard...");
			Boolean result = AppiumWrapper.hideKeyboard();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("hide the keyboard");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to hide keyboard");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	@Override
	public Boolean isKeyboardShown() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * use this method to click on Android Back Button and do necessary report task.
	 *
	 */
	public void pressAndroidBackButton() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to click on Android Back Button...");
			Boolean result = AppiumWrapper.pressAndroidBackButton();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Clicked on Android Back Button");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to click on Android Back button");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		
	}

	/**
	 * use this method to click on Android Home Button and do necessary report task.
	 *
	 *
	 */
	public void pressAndroidHomeButton() {
		ActionResult actionResult = null;
		try {
			logger.info("trying to click on Android Home Button...");
			Boolean result = AppiumWrapper.pressAndroidHomeButton();
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Clicked on Android Home Button");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to click on Android Home button");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
		
	}

	/**
	 * use this method to append text and do necessary report task.
	 * 
	 * @param eLocator
	 * @param valueToEnter
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void pickerWheelEnterText(BaseElement eLocator, String valueToEnter) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to append text for the picker wheel element: '" + ElementsUtil.getElementName(eLocator.getName())
					+ "'...");
			boolean result = AppiumWrapper.pickerWheelEnterText(eLocator, valueToEnter);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Entered text for picker wheel element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to enter text for picker wheel element: '"
						+ ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to press element and release element from one position to another position using coordinates
	 * 
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 *
	 */

	public void pressAndReleaseElementUsingCoordinates(int xStart, int yStart, int xEnd, int yEnd) {
		ActionResult actionResult = null;
		try {
			logger.info(
					"trying to press on element using corordinates...");
			boolean result = AppiumWrapper.pressAndReleaseElementUsingCoordinates(xStart, yStart, xEnd, yEnd);			
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription("released the element");
				logger.info(actionResult.getDescription());
			} else {
				actionResult.setDescription("Failed to release the element.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}
	
	/**
	 * use this method to click on the switch element and do necessary report task.
	 * 
	 * @param eLocator
	 * @return actionResult
	 * @throws Exception
	 *
	 */

	public void switchOrSteppersClick(BaseElement eLocator) {
		ActionResult actionResult = null;
		try {
			logger.info("trying to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'...");
			boolean result = AppiumWrapper.switchOrSteppersClick(eLocator);
			actionResult = new ActionResult(result);
			actionResult.setActionName(Thread.currentThread().getStackTrace()[1].getMethodName());
			actionResult.setElementName(eLocator.getName());

			if (actionResult.getStatus() == true) {
				actionResult.setDescription(
						"Clicked on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription(
						"Failed to click on the element: '" + ElementsUtil.getElementName(eLocator.getName()) + "'.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	
	@Override
	public String getClipboardText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClipboardText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shake() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lockDevice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlockDevice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isDeviceLocked() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void toggleAirplaneMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggleData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggleWifi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggleLocationServices() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		
	}

	
}
