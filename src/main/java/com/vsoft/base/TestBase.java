package com.vsoft.base;

import java.lang.reflect.Method;
import java.util.Date;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.automation.config.OpenBrowserFor;
import com.vsoft.automation.utilities.ExceptionUtil;
import com.vsoft.automation.utilities.MailUtil;
import com.vsoft.core.extreport.ExtentReportManager;
import com.vsoft.core.extreport.ExtentTestManager;

public class TestBase extends PageBase {
	private String xmlTestName;

	/**
	 * use this method to initiate extent reporter in before suite.
	 *
	 */
	@BeforeSuite
	public void createSuiteConfig() {
		try {
			// createSuiteReport
			ExtentReportManager.initExtentReporter("VSoft");
		} catch (Exception e) {
			logger.error("Create suite config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to close extent reporter in after suite.
	 *
	 */
	@AfterSuite
	public void closeSuiteConfig(ITestContext tst) {
		try {
			// closeSuiteReport
			ExtentReportManager.getInstance().flush();
			if (!ConfigProperties.IS_DEBUG_RUN && ConfigProperties.SEND_MAIL_REPORT) {
				String mailSubject = "Report for " + tst.getSuite().getName() + " Executed on " + new Date();
				MailUtil.confiureAndSendMail(mailSubject, mailSubject, ExtentReportManager.htmlReportPath);
			}
		} catch (Exception e) {
			logger.error("Close suite config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to initiate browser in before test.
	 *
	 */
	@BeforeTest
	public void createTestConfig() {
		try {
			ExtentTestManager.enableReporting();
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYTEST) {
				openApplication(ConfigProperties.PLATFORM);
			}
		} catch (Exception e) {
			logger.error("Create test config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to close browser and get the skipped test details in after
	 * test.
	 * 
	 * @param ITestContext
	 */
	@AfterTest
	public void closeTestConfig(ITestContext tst) {
		try {
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYTEST) {
				closeApplication();
			}

			IResultMap skTests = tst.getSkippedTests();
			if (skTests.size() > 0) {
				ExtentTestManager.createTest(xmlTestName + ":SkippedTests");

				for (ITestResult result : skTests.getAllResults()) {
					String clsName = result.getMethod().getTestClass().getName();
					String tMethodName = result.getMethod().getMethodName();
					ExtentTestManager.setNodeTest(
							ExtentTestManager.getTest("SkippedTests").createNode(clsName + ":" + tMethodName));
					ExtentTestManager.skipTest(tMethodName + " TestMethod Skipped: className:" + clsName);
				}

				ExtentReportManager.getInstance().flush();

			}
		} catch (Exception e) {
			logger.error("Close test config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to launch browser,create test and set the screen test policy
	 * in before class.
	 * 
	 * @param ITestContext
	 */
	@BeforeClass
	public void createClassConfig(ITestContext tst) {
		try {
			ExtentTestManager.enableReporting();
			xmlTestName = tst.getName();
			// createClassReporter
			ExtentTestManager.setReporter(ExtentReportManager.getInstance(), ConfigProperties.SCREEN_SHOT_POLICY);
			ExtentTestManager.createTest(xmlTestName + ":" + this.getClass().getSimpleName());
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYCLASS) {
				openApplication(ConfigProperties.PLATFORM);
			}
		} catch (Exception e) {
			logger.error("Create class config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to close extent reporter and browser in after class.
	 *
	 */
	@AfterClass
	public void closeClassConfig() {
		try {
			// closeClassReport
			ExtentReportManager.getInstance().flush();
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYCLASS) {
				closeApplication();
			}
		} catch (Exception e) {
			logger.error("Close class config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to launch browser and set node test in before class.
	 * 
	 * @param Method
	 */
	@Parameters("platform")
	@BeforeMethod
	public void createMethodConfig(Method method, String platform) {
		try {
			ExtentTestManager.enableReporting();
			// createTMReporter
			ExtentTestManager.setNodeTest(
					ExtentTestManager.getTest(getClass().getSimpleName()).createNode("TC ID: " + method.getName()
							+ " <br/> " + "TC Description: " + method.getAnnotation(Test.class).description()));
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYMETHOD) {
				System.out.println("Platform is "+platform);
				openApplication(platform);
			}
		} catch (Exception e) {
			logger.error("Create method config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}

	/**
	 * use this method to close browser,remove node test and to through failure
	 * message on failure in after method.
	 * 
	 * @param Method
	 * @param ITestResult
	 */
	@AfterMethod
	public void closeMethodConfig(Method method, ITestResult result) {
		try {
			// closeTMReporter
			if (result.getStatus() == ITestResult.FAILURE) {
				ExtentTestManager.getNodeTest().fail(result.getThrowable().getMessage());
			}
			ExtentTestManager.removeNodeTest();
			if (ConfigProperties.OPENBROWSER == OpenBrowserFor.EVERYMETHOD) {
				//closeApplication();
			}
		} catch (Exception e) {
			logger.error("Close method config Exception: " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}
}