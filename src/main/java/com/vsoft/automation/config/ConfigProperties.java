package com.vsoft.automation.config;

import com.vsoft.automation.utilities.PropertyUtil;
import com.vsoft.core.report.ScreenshotPolicy;

public abstract class ConfigProperties {

	private static final String CONFIG_PROPERTIES_FILEPATH = ".\\src\\main\\resources\\config.properties";
	private static final PropertyUtil PROPERTIES_UTIL = new PropertyUtil(CONFIG_PROPERTIES_FILEPATH);

	public static final String TEST_DATA_FILE_TYPE = "xlsx";
	public static final String TEST_DATA_FILE_LOCATION = "";
	public static final String TEST_DATA_FILE_NAME = "Global";

	public static final String TEST_REPORT_FILE_TYPE = "html";
	
	//Windows OS
	public static final String TEST_REPORT_FILE_LOCATION = "src\\..\\Reports";
	public static final String TEST_REPORT_SCREENSHOT_LOCATION = TEST_REPORT_FILE_LOCATION + "\\ScreenShots";
	
	//Mac OS
	public static final String TEST_REPORT_FILE_LOCATION_Mac_OS = "src//..//Reports";
	public static final String TEST_REPORT_SCREENSHOT_LOCATION_Mac_OS = TEST_REPORT_FILE_LOCATION_Mac_OS + "//ScreenShots";

	public static final String TEST_REPORT_FILE_NAME = "VSoftAutomation";

	public static final ScreenshotPolicy SCREEN_SHOT_POLICY = ScreenshotPolicy.TAKE_SCREENSHOTS_FOR_ONLY_FAIL;

	public static final String ENVIRONMENT = "";
	public static final String PLATFORM = "ANDROID";
	public static final String ANDROIDVERSION = "7.0";
	public static final String ANDROIDUDID = "CB5A27GJ0M";
//	public static final String ANDROIDUDID = "emulator-5554";
	public static final OpenBrowserFor OPENBROWSER = OpenBrowserFor.EVERYMETHOD;

	public static final String URL = "";
	public static final String USERNAME = "ROML0027";
	public static final String PASSWORD = "Devdev2345!!";

	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int EXPLICIT_WAIT_TIME = 20;
	public static final Boolean HIGHLIGHT_ELEMENT = false;
	public static final Boolean LAUNCH_TESTREPORT_AFTER_EXECUTION = false;

	public static final String WORDFILEPATH = "C:\\Users\\bdasari\\Downloads\\AnnualFeeLetter.docx";

	public static final String REPORT_FROM_MAIL = "testingvsoft@gmail.com";
	public static final String REPORT_FROM_MAIL_PASSWORD = "Vsoft@123";

	public static final String[] REPORT_TO_MAIL = { "bdsari@vsoftconsulting.com" };
	public static final String[] REPORT_TO_CC_MAIL = { "bdsari@vsoftconsulting.com" };
	public static final String[] REPORT_TO_BCC_MAIL = {};

	public static final Boolean SEND_MAIL_REPORT = false;

	public static final Boolean IS_DEBUG_RUN = debugCheck();

	public static Boolean debugCheck() {
		return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString()
				.indexOf("jdwp") >= 0;
	}

	public static String getOSName() {
		return System.getProperty("os.name");
	}
}
