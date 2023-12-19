package com.myntra.error;

public class InvalidSelectorException extends RuntimeException {
	String locatorType;

	public InvalidSelectorException(String locatorType) {
		this.locatorType = locatorType;
	}

	@Override
	public String getMessage() {
		return "invalid locator type: " + locatorType;
	}
}
