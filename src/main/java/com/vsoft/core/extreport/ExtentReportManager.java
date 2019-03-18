package com.vsoft.core.extreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.impl.ConsoleLogger;

public class ExtentReportManager {

	public static ExtentReports extent;
	public static ExtentReporter report;
	public static String htmlReportPath;

	/**
	 * use this method to initiate extent report along with report path.
	 * 
	 * @param reportName
	 *
	 */
	public static void initExtentReporter(String reportName) {
		extent = new ExtentReports();
		htmlReportPath = "src\\..\\Reports\\" + reportName + getUniqId() + ".html";
		report = new ExtentHtmlReporter(htmlReportPath);
		ConsoleLogger logger = new ConsoleLogger();
		extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
		extent.attachReporter(report, logger);
	}

	/**
	 * use this method to get Extent Reports.
	 *
	 */
	public static ExtentReports getInstance() {
		return extent;
	}

	/**
	 * use this method to close Extent Reports.
	 *
	 */
	public void closeExtentReport() {
		extent.flush();
	}

	/**
	 * use this method to get unique id.
	 *
	 */
	public static String getUniqId() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmss");
		return sd.format(new Date());
	}
}
