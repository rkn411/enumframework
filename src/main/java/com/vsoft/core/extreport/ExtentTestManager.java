package com.vsoft.core.extreport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.automation.utilities.ScreenshotUtil;
import com.vsoft.core.report.ActionResult;
import com.vsoft.core.report.Screenshot;
import com.vsoft.core.report.ScreenshotPolicy;

public class ExtentTestManager {

	static Map<String, ExtentTest> extentTestMap = new HashMap<String, ExtentTest>();
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> mTest = new ThreadLocal<ExtentTest>();

	private static ThreadLocal<ScreenshotPolicy> screenshotPolicy = new ThreadLocal<ScreenshotPolicy>();

	private static ThreadLocal<Boolean> stopReporting = new ThreadLocal<Boolean>();
	
	public static void disableReporting() {
		stopReporting.set(true);
	}
	
	public static void enableReporting() {
		stopReporting.set(false);
	}
	
	/**
	 * use this method to set the extent reporter and screen shot policy.
	 * 
	 * @param ExtentReports
	 * @param ScreenshotPolicy
	 *
	 */
	public static synchronized void setReporter(ExtentReports extent, ScreenshotPolicy policy) {
		ExtentTestManager.extent = extent;
		setScreenshotPolicy(policy);
	}

	/**
	 * use this method to set screen shot policy.
	 * 
	 * @param ScreenshotPolicy
	 *
	 */
	public static synchronized void setScreenshotPolicy(ScreenshotPolicy policy) {
		screenshotPolicy.set(policy);
	}

	
	/**
	 * use this method to get screen shot policy.
	 *
	 */
	public static synchronized ScreenshotPolicy getScreenshotPolicy() {
		return screenshotPolicy.get();
	}

	/**
	 * use this method to get Extent Test details.
	 *
	 */

	public static synchronized ExtentTest getTest(String tClsName) {
		String strExtTestName = Thread.currentThread().getId() + tClsName;
		return extentTestMap.get(strExtTestName);
	}

	/**
	 * use this method to create test.
	 * 
	 * @param testName
	 *
	 */
	public static synchronized void createTest(String testName) {
		createTest(testName, "");
	}

	/**
	 * use this method to create test along with description.
	 * 
	 * @param testName
	 * @param desc
	 *
	 */
	public static synchronized ExtentTest createTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		String cName = testName.split(":")[1];
		extentTestMap.put((Thread.currentThread().getId() + cName), test);
		return test;
	}

	/**
	 * use this method to set node test.
	 * 
	 * @param ExtentTest
	 *
	 */
	public static void setNodeTest(ExtentTest test) {
		mTest.set(null);
		mTest.set(test);
	}

	/**
	 * use this method to remove node test.
	 *
	 */
	public static void removeNodeTest() {
		mTest.set(null);
	}

	/**
	 * use this method to get node test.
	 *
	 */
	public static ExtentTest getNodeTest() {
		return mTest.get();
	}

	/**
	 * use this method for reporting pass test.
	 * 
	 * @param desc
	 *
	 */
	public static void passStep(String desc) {
		if (!stopReporting.get()) {
			mTest.get().log(Status.PASS, desc);
		}
		
	}

	/**
	 * use this method for reporting fail test.
	 * 
	 * @param desc
	 *
	 */
	public static void failStep(String desc) {
		mTest.get().log(Status.FAIL, desc);
		Assert.fail(desc);
	}

	/**
	 * use this method for reporting fail test along with on failure exit or not
	 * parameter.
	 * 
	 * @param desc
	 * @param testExitOnFailure
	 *
	 */
	public static void failStep(String desc, boolean testExitOnFailure) {
		mTest.get().log(Status.FAIL, desc);
		if (testExitOnFailure) {
			Assert.fail(desc);
		}
	}

	/**
	 * use this method for reporting skip step.
	 * 
	 * @param desc
	 *
	 */
	public static void skipStep(String desc) {
		mTest.get().log(Status.SKIP, desc);
	}

	/**
	 * use this method for reporting skip Test.
	 * 
	 * @param desc
	 *
	 */
	public static void skipTest(String desc) {
		mTest.get().skip(desc);
	}

	/**
	 * use this method for reporting pass test along with taking screen shot
	 * parameter.
	 * 
	 * @param desc
	 * @param mediaModel
	 *
	 */
	public static void passStep(String desc, MediaEntityModelProvider mediaModel) {
		if (!stopReporting.get()) {
			mTest.get().log(Status.PASS, desc, mediaModel);
		}
		
	}

	/**
	 * use this method for reporting fail test along with taking screen shot
	 * parameter.
	 * 
	 * @param desc
	 * @param mediaModel
	 *
	 */
	public static void failStep(String desc, MediaEntityModelProvider mediaModel) {
		mTest.get().log(Status.FAIL, desc, mediaModel);
		Assert.fail(desc);
	}

	/**
	 * use this method for reporting fail test along with taking screen shot
	 * parameter and also on failure exit parameter.
	 * 
	 * @param desc
	 * @param mediaModel
	 * @param testExitOnFailure
	 *
	 */
	public static void failStep(String desc, MediaEntityModelProvider mediaModel, boolean testExitOnFailure) {
		mTest.get().log(Status.FAIL, desc, mediaModel);
		if (testExitOnFailure) {
			Assert.fail(desc);
		}
	}

	/**
	 * use this method for reporting info Test.
	 * 
	 * @param desc
	 *
	 */
	public static void infoStep(String desc) {
		mTest.get().log(Status.INFO, desc);
	}

	/**
	 * use this method for reporting info test along with taking screen shot
	 * parameter.
	 * 
	 * @param desc
	 * @param mediaModel
	 *
	 */
	public static void infoStep(String desc, MediaEntityModelProvider mediaModel) {
		mTest.get().log(Status.INFO, desc, mediaModel);
	}

	/**
	 * use this method for info step reporting and for taking screen shots if
	 * needed.
	 * 
	 * @param actionResult
	 *
	 */
	public static void infoStep(ActionResult actionResult) {

		if (screenshotPolicy.get().isScreenshotNeededForAllSteps() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.takeScreenshot(actionResult);
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromPath(screenshot.getScreenshotFilePath()).build();
				infoStep(actionResult.getDescription(), mediaModel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			infoStep(actionResult.getDescription());
		}
	}

	/**
	 * use this method for pass step reporting and for taking screen shots if
	 * needed.
	 * 
	 * @param actionResult
	 *
	 */
	public static void passStep(ActionResult actionResult) {

		if (screenshotPolicy.get().isScreenshotNeededForAllSteps() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.takeScreenshot(actionResult);

				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromPath(screenshot.getScreenshotFilePath()).build();
				passStep(actionResult.getDescription(), mediaModel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			passStep(actionResult.getDescription());
		}
	}

	/**
	 * use this method for fail step reporting and for taking screen shots if
	 * needed.
	 * 
	 * @param actionResult
	 *
	 */
	public static void failStep(ActionResult actionResult) {

		if (!screenshotPolicy.get().isScreenshotIgnored() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.takeScreenshot(actionResult);
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot.getBase64Format()).build();
				failStep(actionResult.getDescription(), mediaModel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			failStep(actionResult.getDescription());
		}
	}
	
	/**
	 * use this method for fail step reporting and for taking screen shots if
	 * needed.
	 * 
	 * @param actionResult
	 *
	 */
	public static void assertFailStep(ActionResult actionResult) {

		if (!screenshotPolicy.get().isScreenshotIgnored() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.assertTakeScreenshot();
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot.getBase64Format()).build();
				failStep(actionResult.getDescription(), mediaModel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			failStep(actionResult.getDescription());
		}
	}
	

	/**
	 * use this method for fail step reporting and for taking screen shots if needed
	 * and on failure exit or not parameter.
	 * 
	 * @param actionResult
	 * @param testExitOnFailure
	 *
	 */
	public static void failStep(ActionResult actionResult, boolean testExitOnFailure) {

		if (!screenshotPolicy.get().isScreenshotIgnored() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.takeScreenshot(actionResult);
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot.getBase64Format()).build();
				failStep(actionResult.getDescription(), mediaModel, testExitOnFailure);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			failStep(actionResult.getDescription(), testExitOnFailure);
		}
	}
	
	/**
	 * use this method for fail step reporting and for taking screen shots if needed
	 * and on failure exit or not parameter.
	 * 
	 * @param actionResult
	 * @param testExitOnFailure
	 *
	 */
	public static void assertFailStep(ActionResult actionResult, boolean testExitOnFailure) {

		if (!screenshotPolicy.get().isScreenshotIgnored() && !ConfigProperties.IS_DEBUG_RUN) {
			try {
				Screenshot screenshot = ScreenshotUtil.assertTakeScreenshot();
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot.getBase64Format()).build();
				failStep(actionResult.getDescription(), mediaModel, testExitOnFailure);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			failStep(actionResult.getDescription(), testExitOnFailure);
		}
	}
}