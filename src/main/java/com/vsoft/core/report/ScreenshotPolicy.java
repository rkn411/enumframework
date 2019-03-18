package com.vsoft.core.report;

public enum ScreenshotPolicy {
	TAKE_SCREENSHOTS_OF_ALL_STEPS, TAKE_SCREENSHOTS_FOR_ONLY_FAIL, DO_NOT_TAKE_SCREENSHOTS;

	public boolean isScreenshotNeededForFailSteps() {
		if (this.equals(TAKE_SCREENSHOTS_FOR_ONLY_FAIL))
			return true;
		else
			return false;
	}

	public boolean isScreenshotNeededForAllSteps() {
		if (this.equals(TAKE_SCREENSHOTS_OF_ALL_STEPS))
			return true;
		else
			return false;
	}

	public boolean isScreenshotIgnored() {
		if (this.equals(DO_NOT_TAKE_SCREENSHOTS))
			return true;
		else
			return false;
	}

}
