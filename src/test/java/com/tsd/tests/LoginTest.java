package com.tsd.tests;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;

import org.testng.annotations.Test;

import com.example.locators.HomePage;
import com.example.locators.LoginPage;
import com.example.locators.PopUpPO;
import com.vsoft.automation.utilities.ExceptionUtil;
import com.vsoft.base.TestBase;

public class LoginTest extends TestBase {

	@Test(priority = 1, description = "User should login successfully with valid credentials")
	public void verifyLoginWithValidCredentials() throws Exception {
		try {
			if (platformName.get().equals("ios")) {
				if (LoginPage.btnAllow.isDisplayed())
					LoginPage.btnAllow.click();
			}
			LoginPage.txtUsername.verifyDisplayed();
			LoginPage.txtUsername.click();
			LoginPage.txtUsername.enterText("avarmaa");
			getDriver().hideKeyboard();
			LoginPage.txtPassword.click();
			LoginPage.txtPassword.enterText("123");
			getDriver().hideKeyboard();
			if (platformName.get().contains("android")) {
				LoginPage.btnLogin.click();
			}
			if (platformName.get().equals("android")) {
				HomePage.homepageTitle.verifyDisplayed();
			} else {
				HomePage.homepageTitle.verifyDisplayed();
			}
			HomePage.btnLogout.click();
			HomePage.btnOk.click();
		} catch (Exception e) {
			logger.error("Test run with exception and failed " + ExceptionUtil.getExceptionStackTrace(e));
			failStep("Failed to verify login with valid credentials.See error log for more details ");
		}
	}

	@Test(priority = 0, description = "User should not login with invalid credentials")
	public void verifyLoginWithInValidCredentials() throws Exception {
		try {
			if (platformName.get().equals("ios")) {
				if (LoginPage.btnAllow.isDisplayed())
					LoginPage.btnAllow.click();
			}
			LoginPage.txtUsername.verifyDisplayed();
			LoginPage.txtUsername.click();
			LoginPage.txtUsername.enterText("avarmas");
			getDriver().hideKeyboard();
			LoginPage.txtPassword.click();
			LoginPage.txtPassword.enterText("123");
			getDriver().hideKeyboard();
			if (platformName.get().contains("android")) {
				LoginPage.btnLogin.click();
			}
			PopUpPO.btnOk.click();
			LoginPage.txtUsername.verifyDisplayed();
			LoginPage.txtPassword.verifyDisplayed();
			LoginPage.btnLogin.verifyDisplayed();
		} catch (Exception e) {
			logger.error("Test run with exception and failed " + ExceptionUtil.getExceptionStackTrace(e));
			failStep("Failed to verify login with invalid credentials .See error log for more details ");
		}
	}
}
