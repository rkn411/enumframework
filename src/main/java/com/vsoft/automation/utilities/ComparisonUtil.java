package com.vsoft.automation.utilities;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;
import static com.vsoft.core.extreport.ExtentTestManager.passStep;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.vsoft.core.report.ActionResult;

public class ComparisonUtil {

	private static final Logger logger = Logger.getLogger(ComparisonUtil.class);

	/**
	 * use this method to check particular string present or not inside a List
	 *
	 *
	 * @param wordToVerify
	 * @throws Exception
	 *
	 */
	public static Boolean checkStringInsideList(List<WebElement> list, String expectedString) {
		ActionResult actionResult = null;
		Boolean stringStatus = false;
		try {
			logger.info("checking the string inside list");
			for (WebElement el : list) {
				if (el.getText().trim().equals(expectedString)) {
					stringStatus = true;
					break;
				}
			}
			actionResult = new ActionResult(stringStatus);
			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Successfully found the " + expectedString + " String inside list.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Failed to find the " + expectedString + " String inside list.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);
			}
		} catch (Exception e) {
			actionResult = new ActionResult(false);
			actionResult.setDescription("Failed to find the " + expectedString + " String inside list.");
			failStep(actionResult);
			logger.error("Exception Details: " + e.getMessage());
		}
		return stringStatus;
	}

}