package com.tsd.tests;

import static com.vsoft.automation.utilities.ExceptionUtil.getExceptionStackTrace;

import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.example.locators.APSRTC;
import com.vsoft.actions.AppiumReportWrapper;
import com.vsoft.base.TestBase;

public class APSRTCTest extends TestBase {

	private static Logger logger = Logger.getLogger(APSRTCTest.class);

	@Test
	public void bookTicket() {
		try {
			APSRTC.iconMainBookItem.click();
			APSRTC.iconSubBookItem.waitForElementToBeVisible(30);
			APSRTC.iconSubBookItem.click();
			APSRTC.btnCheckAvailability.waitForElementToBeVisible(30);
			APSRTC.editFrom.click();
			APSRTC.editBoarding.enterText("TENALI");
			APSRTC.editSelection.updateLocator(platformName.get(), "TENALI");
			if (APSRTC.editSelection.isDisplayed()) {
				APSRTC.editSelection.click();
			}
			getDriver().hideKeyboard();

			APSRTC.editTo.click();
			getDriver().hideKeyboard();
			APSRTC.editDropping.waitForElementToBeVisible(5);
			APSRTC.editDropping.enterText("HYDERABAD");
			getDriver().hideKeyboard();
			APSRTC.editSelection.updateLocator(platformName.get(), "HYDERABAD");
			System.out.println("Dropping " + APSRTC.editSelection.getAndroidLocator());
			if (APSRTC.editSelection.isDisplayed()) {
				APSRTC.editSelection.click();
			}
			getDriver().hideKeyboard();

			APSRTC.editDeparts.click();
			APSRTC.btnDateSelection.updateLocator(platformName.get(), "19");
			APSRTC.btnDateSelection.click();
			APSRTC.btnCheckAvailability.click();

			APSRTC.selectBusSeats.updateLocator(platformName.get(), "4359");
			Set<String> cnts = driver.get().getContextHandles();
			for (String cnt : cnts) {
				if (cnt.toLowerCase().contains("webview")) {
					driver.get().context(cnt);
					break;
				}
			}
			APSRTC.textBusElement.scrollIntoElement("4359");
			APSRTC.selectBusSeats.click();

			APSRTC.spinnerDropping.click();
			APSRTC.selectDropping.updateLocator(platformName.get(), "HYDERABAD MGBS");
			APSRTC.selectDropping.click();

			APSRTC.btnShowLayout.click();
		} catch (Exception e) {
			logger.info("Exception Details: " + getExceptionStackTrace(e));
		}

	}

}
