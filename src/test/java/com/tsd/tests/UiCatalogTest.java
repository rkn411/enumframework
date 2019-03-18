package com.tsd.tests;

import static com.vsoft.automation.utilities.ExceptionUtil.getExceptionStackTrace;

import org.testng.annotations.Test;

import com.example.locators.UiCatalog;
import com.vsoft.base.TestBase;

public class UiCatalogTest extends TestBase {

	@Test(enabled = false)
	public void scrollingbasedonText() {
		UiCatalog.lstMainItem.updateLocator(platformName.get(),"Web View");
		UiCatalog.lstMainItem.scrollToElementByJs("Web View");
		UiCatalog.lstMainItem.click();

	}

	@Test(enabled = false)
	public void slider() throws InterruptedException {
		try {
			UiCatalog.lstMainItem.updateLocator(platformName.get(),"Sliders");
			UiCatalog.lstMainItem.click();
			UiCatalog.deviceActions.pressAndReleaseElementUsingCoordinates(159, 166, 122, 2);
		} catch (Exception e) {
			logger.error("Exception Details: " + getExceptionStackTrace(e));
		}
	}

	@Test(enabled = false)
	public void pickerWheel() {
		UiCatalog.lstMainItem.updateLocator(platformName.get(),"Picker View");
		UiCatalog.lstMainItem.click();
		UiCatalog.pickerWheelRed.pickerWheelEnterText("80");
	}
	
	@Test(enabled = false)
	public void switches() {
		UiCatalog.lstMainItem.updateLocator(platformName.get(),"Switches");
		UiCatalog.lstMainItem.scrollToElementByJs("Switches");
		UiCatalog.lstMainItem.click();
		UiCatalog.switchDefault.switchOrSteppersClick();
	}
	
	@Test(enabled = false)
	public void textField() {
		UiCatalog.lstMainItem.updateLocator(platformName.get(),"Text Fields");
		UiCatalog.lstMainItem.scrollToElementByJs("Text Fields");
		UiCatalog.lstMainItem.click();
		UiCatalog.txtSpecificKeyboard.click();
		UiCatalog.txtSpecificKeyboard.enterText("success");
		UiCatalog.allActions.hideKeyboard();
	}
	
	@Test
	public void Steppers() {
		UiCatalog.lstMainItem.updateLocator(platformName.get(),"Steppers");
		UiCatalog.lstMainItem.scrollToElementByJs("Steppers");
		UiCatalog.lstMainItem.click();
		UiCatalog.incrementCustom.switchOrSteppersClick();
		UiCatalog.decrementCustom.switchOrSteppersClick();
	}
}