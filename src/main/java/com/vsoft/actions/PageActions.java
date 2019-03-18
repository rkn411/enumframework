package com.vsoft.actions;

import com.vsoft.elements.core.BaseElement;

public interface PageActions {

	// Navigation
	void get(String url);

	String getCurrentURL();

	// Window Operations
	String saveCurrentWindowHandle();

	String switchToNewWindow();

	void switchToMainWindow();

	void switchToWindowByTitle(String wndTitle);

	void switchToWindowByChildElement(BaseElement eLocator);

	void maximizeWindow();

	void refresh();

	void closeCurrentWindow();

	void closeAllWindows();

	// Frame Operations
	void switchToFrame(String frameName);

	void switchToFrameByUsingChild(BaseElement eChildLocator);

	// Alert Operations
	void acceptIfAlertIsPresent();

	String getAlertText();

	void dismissAlert();
}
