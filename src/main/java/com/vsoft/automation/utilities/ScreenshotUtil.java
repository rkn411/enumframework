package com.vsoft.automation.utilities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.base.PageBase;
import com.vsoft.core.report.ActionResult;
import com.vsoft.core.report.Screenshot;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtil extends PageBase {

	/**
	 * To take screenshot using Ashot
	 *
	 * @param screenshotFilePath
	 * @return Screenshot
	 */
	public static Screenshot takeScreenshot2(String screenshotFilePath) {

		ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
		File screenshotFile = new File(screenshotFilePath);

		try {
			ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Screenshot(screenshotFile.getAbsolutePath(), screenshotFile);
	}

	/**
	 * To generate screenshot path and take screenshot using Ashot
	 * 
	 * @param result
	 * @return Screenshot
	 */
	public static Screenshot takeScreenshot2(ActionResult result) {

		String screenshotFilePath = generateScreenshotPath(result.getActionName(), result.getElementName());

		ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
		File screenshotFile = new File(screenshotFilePath);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Screenshot(screenshotFile.getAbsolutePath(), screenshotFile);
	}

	/**
	 * To generate screenshot path and take screenshot using Ashot
	 * 
	 * @return Screenshot
	 */
	public static Screenshot assertTakeScreenshot() {

		String screenshotFilePath = assertgenerateScreenshotPath();
		ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
		File screenshotFile = new File(screenshotFilePath);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Screenshot(screenshotFile.getAbsolutePath(), screenshotFile);
	}

	/**
	 * To generate screenshot path
	 *
	 * @param actionName
	 * @param elementName
	 * @return ScreenshotPath
	 */
	private static String generateScreenshotPath(String actionName, String elementName) {
		File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION);
		if (!fld.exists()) {
			fld.mkdirs();
		}
		return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION + "\\" + elementName.replace(" ", "") + "_" + actionName
				+ TextUtil.getCurrentTimeStamp() + ".png";
	}

	/**
	 * To generate screenshot path
	 *
	 * @param actionName
	 * @param elementName
	 * @return ScreenshotPath
	 */
	private static String assertgenerateScreenshotPath() {
		File fld = new File(ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION);
		if (!fld.exists()) {
			fld.mkdirs();
		}
		return ConfigProperties.TEST_REPORT_SCREENSHOT_LOCATION + "\\AssertFailed_" + TextUtil.getCurrentTimeStamp()
				+ ".png";
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
