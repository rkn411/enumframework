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

	private static Logger logger = Logger.getLogger(DocuCite.class);
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

		String PreDocCount = null;
		String PostDocCount = null;
		String firstName, lastName, middleName;
		try {
			if (platformName.get().equalsIgnoreCase("ios"))
				DocuCite.btnAllowDocuCite.click();
			login.selectLanguageandLogin("English", ConfigProperties.USERNAME, ConfigProperties.PASSWORD);

			neworder.selectDistributor("US - 13039 : NAOMY C WILLIS");

			firstName = GenerateDataUtil.getFirstName();
			middleName = GenerateDataUtil.getLastName();
			lastName = GenerateDataUtil.getLastName();

			neworder.enterNameDetails(firstName, middleName, lastName);

			// adding documents and verifying

			DocuCite.elementFirstMiddleName.waitForElementToBeVisible(15);
			System.out.println("First and middle Name is " + DocuCite.elementFirstMiddleName.getElementText());
			Assertions.verify("Check First and middle name is ", firstName + " " + middleName,
					DocuCite.elementFirstMiddleName.getElementText(), true);
			System.out.println("Last Name is " + DocuCite.elementLastName.getElementText());
			Assertions.verify("Check Last name is ", lastName, DocuCite.elementLastName.getElementText(), true);

			PreDocCount = DocuCite.elementDocumentCount.getElementText();
			System.out.println("Doc Count " + PreDocCount);

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

			PostDocCount = DocuCite.elementDocumentCount.getElementText();
			System.out.println("pst Count " + PostDocCount);

			DocuCite.elementCloudIcon.click();

			// Ready to Go page
			DocuCite.textReadToGo.waitForElementToBeVisible(10);
			System.out.println("Full name " + DocuCite.textFullName.getElementText());
			Assertions.verify("Check Full Name is ", firstName + " " + middleName + " " + lastName,
					DocuCite.textFullName.getElementText(), true);

			DocuCite.btnOK.click();

			if (DocuCite.popUpProcessPayment.isDisplayed()) {
				DocuCite.btnPaymentNo.click();
			}
			DocuCite.textNewOrderConfirmQueue.verifyDisplayed(20);
			DocuCite.btnOK.click();

		} catch (Exception e) {
			logger.error("Test run with exception and failed " + ExceptionUtil.getExceptionStackTrace(e));
		}
	}
}
