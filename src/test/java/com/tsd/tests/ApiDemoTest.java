package com.tsd.tests;

import org.testng.annotations.Test;

import com.example.locators.ApiDemo1;
import com.vsoft.actions.Assertions;
import com.vsoft.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ApiDemoTest extends TestBase {

	@Test(enabled = false)
	public void scrollingbasedonText() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(), "Views");
		System.out.println("Get text " + ApiDemo1.lstMainItem.getAndroidLocator());
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();

		ApiDemo1.lstMainItem.updateLocator(platformName.get(), "WebView");
		System.out.println("Get text " + ApiDemo1.lstMainItem.getAndroidLocator());
		ApiDemo1.lstMainItem.scrollIntoElement("WebView");
		ApiDemo1.lstMainItem.click();

		((AndroidDriver<MobileElement>) driver.get()).pressKeyCode(AndroidKeyCode.BACK);

	}

	@Test(enabled = false)
	public void HorizontalscrollingbasedonText() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(), "Views");
		System.out.println("Get text " + ApiDemo1.lstMainItem.getAndroidLocator());
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();

		ApiDemo1.lstMainItem.updateLocator(platformName.get(), "Tabs");
		System.out.println("Get text " + ApiDemo1.lstMainItem.getAndroidLocator());
		ApiDemo1.lstMainItem.scrollIntoElement("Tabs");
		ApiDemo1.lstMainItem.click();

		ApiDemo1.lstMainItem.updateLocator(platformName.get(), "5. Scrollable");
		System.out.println("Get text " + ApiDemo1.lstMainItem.getAndroidLocator());
		ApiDemo1.lstMainItem.scrollIntoElement("5. Scrollable");
		ApiDemo1.lstMainItem.click();

		// TouchAction touchAction = new TouchAction(driver.get());
		// touchAction
		// .press(ElementOption
		// .element(driver.get().findElement(MobileBy.xpath("//android.widget.TextView[@text='Tab
		// 4']"))))
		// .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		// .moveTo(ElementOption
		// .element(driver.get().findElement(MobileBy.xpath("//android.widget.TextView[@text='Tab
		// 1']"))))
		// .release().perform();

		ApiDemo1.tabHorizontalItem1.pressAndReleaseElement(ApiDemo1.tabHorizontalItem2);
		ApiDemo1.tabHorizontalItem.updateLocator(platformName.get(),"Tab 8");
		ApiDemo1.tabHorizontalItem.click();
	}

	@Test(enabled=false)
	public void longPressAndRelease() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Views");
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();

		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Drag and Drop");
		ApiDemo1.lstMainItem.scrollIntoElement("Drag and Drop");
		ApiDemo1.lstMainItem.click();

		ApiDemo1.dragItem3.longPressAndReleaseElement(ApiDemo1.dragItem2);

	}
	
	@Test(enabled=false)
	public void listView() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Views");
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Expandable Lists");
		ApiDemo1.lstMainItem.scrollIntoElement("Expandable Lists");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"3. Simple Adapter");
		ApiDemo1.lstMainItem.scrollIntoElement("3. Simple Adapter");
		ApiDemo1.lstMainItem.click();
		
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Group 9");
		ApiDemo1.lstMainItem.scrollIntoElement("Group 9");
		ApiDemo1.lstMainItem.click();
		
	}
	
	@Test(enabled=false)
	public void testEdit() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Views");
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Text");
		ApiDemo1.lstMainItem.scrollIntoElement("Text");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"EditText");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.editTextBox1.enterText("Hello");
		ApiDemo1.editTextBox2.enterText("Nameste");
		
		Assertions.verify("Expected and Actual", "Hello",ApiDemo1.editTextBox1.getElementText(), false);
		
	}
	
	@Test(enabled=false)
	public void testlistselection() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Views");
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Spinner");
		ApiDemo1.lstMainItem.scrollIntoElement("Spinner");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstSpinner1.click();
		ApiDemo1.lstSpinnerPopup.updateLocator(platformName.get(),"blue");
		ApiDemo1.lstSpinnerPopup.click();
		ApiDemo1.textSpinnerView.updateLocator(platformName.get(),"blue");
		ApiDemo1.textSpinnerView.verifyDisplayed();
		
		ApiDemo1.lstSpinner2.click();
		ApiDemo1.lstSpinnerPopup.updateLocator(platformName.get(),"Venus");
		ApiDemo1.lstSpinnerPopup.click();
		ApiDemo1.textSpinnerView.updateLocator(platformName.get(),"Venus");
		ApiDemo1.textSpinnerView.verifyDisplayed();
	}
	
	@Test
	public void testCheckBoxes() {
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"Views");
		ApiDemo1.lstMainItem.scrollIntoElement("Views");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"System UI Visibility");
		ApiDemo1.lstMainItem.scrollIntoElement("System UI Visibility");
		ApiDemo1.lstMainItem.click();
		
		ApiDemo1.lstMainItem.updateLocator(platformName.get(),"System UI Modes");
		ApiDemo1.lstMainItem.scrollIntoElement("System UI Modes");
		ApiDemo1.lstMainItem.click();
		
//		ApiDemo1.chkboxSystemUIModeVisibility.updateLocator("FULLSCRN");
//		ApiDemo1.chkboxSystemUIModeVisibility.click();
//		Assertions.verify("Checking check box is ", "true", ApiDemo1.chkboxSystemUIModeVisibility.getAttributeValue("checked"), true);
//		
//		ApiDemo1.chkboxSystemUIModeVisibility.click();
//		Assertions.verify("Checking check box is ", "false", ApiDemo1.chkboxSystemUIModeVisibility.getAttributeValue("checked"), true);
	}
}