package com.vsoft.actions;

public class TestFailedException extends RuntimeException {

	public TestFailedException() {
		super();
	}

	public TestFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TestFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestFailedException(String message) {
		super(message);
	}

	public TestFailedException(Throwable cause) {
		super(cause);
	}

}
