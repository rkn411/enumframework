package com.vsoft.actions;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;
import static com.vsoft.core.extreport.ExtentTestManager.passStep;

import org.apache.log4j.Logger;

import com.vsoft.core.report.ActionResult;

public class Assertions {
	private static Logger logger = Logger.getLogger(Assertions.class.getName());

	/**
	 * To verify expected condition
	 *
	 * @param expectedCondition
	 * @param verificationDescription
	 */
	public static void verify(boolean expectedCondition, String verificationDescription) {
		ActionResult actionResult = new ActionResult(expectedCondition);
		if (expectedCondition) {
			actionResult.setDescription(verificationDescription + ": Success");
			logger.info(verificationDescription + ": Success");
			passStep(actionResult);
		} else {
			actionResult.setDescription(verificationDescription + ": Failed");
			logger.error(verificationDescription + ": Failed");
			failStep(actionResult);
		}
	}

	/**
	 * Soft Assertion to verify expected condition
	 *
	 * @param expectedCondition
	 * @param verificationDescription
	 * @param testExitOnFailure
	 */
	public static void verify(boolean expectedCondition, String verificationDescription, boolean testExitOnFailure) {
		ActionResult actionResult = new ActionResult(expectedCondition);
		if (expectedCondition) {
			actionResult.setDescription(verificationDescription + ": Success");
			logger.info(verificationDescription + ": Success");
			passStep(actionResult);
		} else {
			actionResult.setDescription(verificationDescription + ": Failed");
			logger.error(verificationDescription + ": Failed");
			failStep(actionResult, testExitOnFailure);
		}
	}

	/**
	 * Soft Assertion to verify two strings
	 *
	 * @param verificationDescription
	 * @param expectedValue
	 * @param actualValue
	 * @param ignoreCase
	 * @param testExitOnFailure
	 */
	public static void verify(String verificationDescription, String expectedValue, String actualValue,
			boolean ignoreCase, boolean testExitOnFailure) {

		logger.info(verificationDescription);

		boolean result;
		if (ignoreCase) {
			result = expectedValue.trim().equalsIgnoreCase(actualValue.trim());
		} else {
			result = expectedValue.trim().equals(actualValue.trim());
		}
		ActionResult actionResult = new ActionResult(result);
		if (result) {
			actionResult.setDescription(verificationDescription + ": Success.");
			logger.info(verificationDescription + ": Success");
			passStep(actionResult);
		} else {
			actionResult.setDescription(verificationDescription + ": Failed. " + "/n" + " Expected: '" + expectedValue
					+ "' but found: " + "'" + actualValue + "'.");
			logger.error(verificationDescription + ": Failed");
			failStep(actionResult, testExitOnFailure);
		}
	}

	/**
	 * To verify two strings
	 *
	 * @param verificationDescription
	 * @param expectedValue
	 * @param actualValue
	 * @param ignoreCase
	 */
	public static void verify(String verificationDescription, String expectedValue, String actualValue,
			boolean ignoreCase) {

		logger.info(verificationDescription);

		boolean result;
		if (ignoreCase) {
			result = expectedValue.trim().equalsIgnoreCase(actualValue.trim());
		} else {
			result = expectedValue.trim().equals(actualValue.trim());
		}
		ActionResult actionResult = new ActionResult(result);
		if (result) {
			actionResult.setDescription(verificationDescription + ": Success");
			logger.info(verificationDescription + ": Success");
			passStep(actionResult);
		} else {
			actionResult.setDescription(verificationDescription + ": Failed. " + "/n" + " Expected: '" + expectedValue
					+ "' but found: " + "'" + actualValue + "'.");
			logger.error(verificationDescription + ": Failed");
			failStep(actionResult);
		}
	}
}