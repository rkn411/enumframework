package com.vsoft.actions;

public interface DeviceActions {
	
	//Keys
	void pressKeyCode();
	
	void longPressKeyCode();
	
	void hideKeyboard();
	
	Boolean isKeyboardShown();
	
	void pressAndroidBackButton();
	
	void pressAndroidHomeButton();
	
	//Clipboard
	String getClipboardText();
	
	void setClipboardText();
	
	//Interactions
	void shake();
	
	void lockDevice();
	
	void unlockDevice();
	
	Boolean isDeviceLocked();
	
	//Network
	void toggleAirplaneMode();
	
	void toggleData();
	
	void toggleWifi();
	
	void toggleLocationServices();
	
	void sendSMS();
	
	//move element
	
	void pressAndReleaseElementUsingCoordinates(int xStart, int yStart, int xEnd, int yEnd);
	
}
