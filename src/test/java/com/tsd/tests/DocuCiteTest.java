package com.tsd.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.doc.pages.LoginPageMethods;
import com.doc.pages.NewOderFlowPage;
import com.example.locators.DocuCite;
import com.vsoft.actions.AppiumReportWrapper;
import com.vsoft.actions.Assertions;
import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.automation.utilities.ExceptionUtil;
import com.vsoft.automation.utilities.GenerateDataUtil;
import com.vsoft.base.TestBase;

public class DocuCiteTest extends TestBase {

	private static Logger logger = Logger.getLogger(DocuCiteTest.class);
	AppiumReportWrapper allActions = new AppiumReportWrapper();

	private LoginPageMethods login;
	private NewOderFlowPage neworder;

	@BeforeMethod
	public void initialization() {
		login = new LoginPageMethods();
		neworder = new NewOderFlowPage();
	}

	@Test
	public void testDocuciteLogin() {
		try {
			// step1
			if (platformName.get().equalsIgnoreCase("ios"))
				DocuCite.btnAllowDocuCite.click();
			login.selectLanguageandLogin("English", ConfigProperties.USERNAME, ConfigProperties.PASSWORD);

			// step2
			neworder.selectDistributor("US - 13039 : NAOMY C WILLIS");
			String firstName = GenerateDataUtil.getFirstName();
			String middleName = GenerateDataUtil.getLastName();
			String lastName = GenerateDataUtil.getLastName();
			neworder.enterNameDetails(firstName, middleName, lastName);

			// step3
			DocuCite.elementFirstMiddleName.waitForElementToBeVisible(15);
			Assertions.verify("Check First and middle name is ", firstName + " " + middleName,
					DocuCite.elementFirstMiddleName.getElementText(), true);
			Assertions.verify("Check Last name is ", lastName, DocuCite.elementLastName.getElementText(), true);
			String PreDocCount = DocuCite.elementDocumentCount.getElementText();
			Assertions.verify("Check douments count", "0 Documents", PreDocCount, false);
			DocuCite.elementPlusIcon.click();
			if (platformName.get().equalsIgnoreCase("ios")) {
				if (DocuCite.popUpCameraAccess.isDisplayed()) {
					DocuCite.btnAllowCameraAccess.click();
				}
				if (DocuCite.popUpLocationAccess.isDisplayed()) {
					DocuCite.btnAllowDocuCite.click();
				}
			}
			DocuCite.btnAutoManual.click();
			DocuCite.btnCapture.click();
			DocuCite.textDocumentQualitymsg.waitForElementToBeVisible(45);
			DocuCite.btnOK.click();
			String PostDocCount = DocuCite.elementDocumentCount.getElementText();
			Assertions.verify("Check douments count", "1 Documents", PostDocCount, false);
			DocuCite.elementCloudIcon.click();
			DocuCite.textReadToGo.waitForElementToBeVisible(10);
			Assertions.verify("Check Full Name is ", firstName + " " + middleName + " " + lastName,
					DocuCite.textFullName.getElementText(), true);
			DocuCite.btnOK.click();

			if (DocuCite.popUpProcessPayment.isDisplayed()) {
				DocuCite.btnPaymentNo.click();
			}
			DocuCite.textNewOrderConfirmQueue.verifyDisplayed(20);
			DocuCite.btnThankUOK.click();

		} catch (Exception e) {
			logger.error("Test run with exception and failed " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}
}
