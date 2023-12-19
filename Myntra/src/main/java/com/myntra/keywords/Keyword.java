package com.myntra.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.myntra.error.InvalidBrowserError;
import com.myntra.error.InvalidSelectorException;


public class Keyword {
	private static RemoteWebDriver driver = null;

	/**
	 * this method return the driver instance. Make sure, before calling this method
	 * one should call {@codeopenBrowser(String browserName)} method so that it can
	 * Initialize driver instance
	 * 
	 * @return driver instance
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	/**
	 * This method will launch specified browser
	 * 
	 * @param browserName to launch
	 */
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
			// System.out.println("Opening Chrome browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			// System.out.println("Opening Firefox browser");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			// System.out.println("Opening Safari browser");
		} else {
			// System.out.println("Invalid browser name");
			throw new InvalidBrowserError(browserName);
		}
	}

	/**
	 * This method will launch specified url.
	 * 
	 * @param url to launch
	 */
	public void openUrl(String url) {
		driver.get(url);
		// System.out.println("Launching Url");
	}

	/**
	 * This method will close the specified browser.
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}

	public void quitAllWindows() {
		driver.quit();
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();

	}

	@Deprecated
	private void enterText(String locatorType, String locatorValue, CharSequence... text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);

	}

	public void enterText(String locator, CharSequence... text) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue, text);
	}

	public void hitKey(int keycode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keycode);
			robo.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public List<String> getTexts(String locatorType, String locatorValue) {
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = getWebElements(locatorType, locatorValue);

		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	public List<String> getTexts(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getTexts(locatorType, locatorValue);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public List<String> getTexts(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}

	public void handleWindows() {
		Set<String> handles = driver.getWindowHandles();
		for (String winhandle : handles) {
			driver.switchTo().window(winhandle);
		}
	}

}
