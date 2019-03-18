package com.doc.pages;

import com.example.locators.DocuCite;
import com.vsoft.actions.AppiumReportWrapper;
import com.vsoft.base.TestBase;

public class LoginPageMethods extends TestBase {
	AppiumReportWrapper allActions = new AppiumReportWrapper();

	public void selectLanguageandLogin(String language, String username, String password) {
		DocuCite.lstSelectLanguage.updateLocator(platformName.get(), language);
		DocuCite.lstSelectLanguage.waitForElementToBeVisible(10);
		DocuCite.lstSelectLanguage.click();
		if (platformName.get().equalsIgnoreCase("android")) {
			DocuCite.btnAllowDocuCite.click();
			DocuCite.btnAllowDocuCite.click();
		}
		// DocuCite.btnAgreeacceptance.click();

		DocuCite.editUsername.waitForElementToBeVisible(30);
		DocuCite.editUsername.enterText(username);
		DocuCite.teditPassword.enterText(password);
		allActions.hideKeyboard();
		DocuCite.btnLogin.click();
	}

}
