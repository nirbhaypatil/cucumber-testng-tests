package com.myntra.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.myntra.error.InvalidSelectorException;
import com.myntra.keywords.Keyword;

public class WaitFor {
	private static FluentWait wait = null;

	static {
		wait = new FluentWait<WebDriver>(Keyword.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(80));
		wait.ignoring(NoSuchElementException.class);
	}

	public static void numberOfElementsToBeMoreThan(String locatorType, String locatorValue, int count) {
		By element = null;
		if (locatorType.equalsIgnoreCase("id")) {
			element = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			element = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			element = By.partialLinkText(locatorValue);
		} else {
			throw new InvalidSelectorException(locatorType);
		}
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, count));
	}

	public static void numberOfElementsToBeMoreThan(String locator, int count) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		numberOfElementsToBeMoreThan(locatorType, locatorValue, count);

	}

	public static void numberOfElementsToBeMoreThan(By productTitle, int count) {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitle, count));

	}

	public static void elementToBeClickeble(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
