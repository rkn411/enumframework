package com.vsoft.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.base.PageBase;
import com.vsoft.core.report.ActionResult;
import com.vsoft.core.report.Screenshot;

public class ScreenshotUtil extends PageBase {

	/**
	 * To generate screenshot path and take screenshot
	 * 
	 * @return Screenshot
	 */
	public static Screenshot assertTakeScreenshot() {

		String screenshotFilePath = assertgenerateScreenshotPath();

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) getDriver());

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(screenshotFilePath);

		// Copy file at destination

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Screenshot(DestFile.getAbsolutePath(), DestFile);
	}

	/**
	 * To generate screenshot path
	 *
	 * @param actionName
	 * @param elementName
	 * @return ScreenshotPath
	 */
	private static String generateScreenshotPath(String actionName, String elementName) {
		if (ConfigProperties.getOSName().contains("Mac OS")) {
			File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION_Mac_OS);
			if (!fld.exists()) {
				fld.mkdirs();
			}
			return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION_Mac_OS + "//" + elementName.replace(" ", "") + "_"
					+ actionName + TextUtil.getCurrentTimeStamp() + ".png";
		} else {
			File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION);
			if (!fld.exists()) {
				fld.mkdirs();
			}
			return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION + "\\" + elementName.replace(" ", "") + "_"
					+ actionName + TextUtil.getCurrentTimeStamp() + ".png";
		}
	}

	/**
	 * To generate screenshot path
	 *
	 * @param actionName
	 * @param elementName
	 * @return ScreenshotPath
	 */
	private static String assertgenerateScreenshotPath() {
		if (ConfigProperties.getOSName().contains("Mac OS")) {
			File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION_Mac_OS);
			if (!fld.exists()) {
				fld.mkdirs();
			}
			return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION_Mac_OS + "//AssertFailed_"
					+ TextUtil.getCurrentTimeStamp() + ".png";
		} else {
			File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION);
			if (!fld.exists()) {
				fld.mkdirs();
			}
			return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION + "\\AssertFailed_" + TextUtil.getCurrentTimeStamp()
					+ ".png";
		}
	}

	/**
	 * To take screenshot using TakesScreenshot
	 *
	 * @param screenshotFilePath
	 * @return Screenshot
	 */
	public static Screenshot takeScreenshot(ActionResult result) {

		String screenshotFilePath = generateScreenshotPath(result.getActionName(), result.getElementName());

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) getDriver());

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(screenshotFilePath);

		// Copy file at destination

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Screenshot(DestFile.getAbsolutePath(), DestFile);
	}

}
