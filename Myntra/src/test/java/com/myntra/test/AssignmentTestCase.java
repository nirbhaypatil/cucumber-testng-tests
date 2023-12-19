package com.myntra.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class AssignmentTestCase {

	@Test
	public void verifyProductAddToBag() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("Smart Watchs Men", Keys.ENTER);
		System.out.println("Check enter text");
		driver.findElement(By.cssSelector(
				"img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/24364440/2023/8/29/fd9b2361-9e13-42e2-940c-08786b6c5a541693293821741-Fire-Boltt-Unisex-Smart-Watches-9221693293821024-1.jpg\"]"))
				.click();
		System.out.println("Check on click");
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		for (String winhandle : handles) {
			driver.switchTo().window(winhandle);
			Thread.sleep(3000);
		}
		System.out.println("check click on img");
		driver.findElement(
				By.cssSelector("span[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]"))
				.click();
		System.out.println("Done");
		// driver.quit();
	}

	@Test
	public void verifySmartWAtchesOfNoiseBrand() {
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("Smart Watches Men", Keys.ENTER);
	}

	@Test
	public void verifySearchResultsForlaptopBagBetweenSelectedRange() {
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("Bags", Keys.ENTER);
		driver.findElement(By.cssSelector("input[value=\"men,men women\"]")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value=\"Laptop Bag\"]")));
		// driver.findElement(By.cssSelector("input[value=\"Laptop Bag\"]")).click();
		System.out.println("check on click");
		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
		wait1.pollingEvery(Duration.ofMillis(500));
		wait1.withTimeout(Duration.ofSeconds(60));
		wait1.ignoring(ElementNotInteractableException.class);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value=\"170.0 TO 10128.0\"]")));
		// driver.findElement(By.cssSelector("input[value=\"170.0 TO
		// 10128.0\"]")).click();
		System.out.println("check on enetr");
		driver.close();
	}

	@Test
	public void verifySearchResultMenBlackRoadsterJackets() {
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		// driver.findElement(By.cssSelector("a[href=\"/men-jackets\"]")).click();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".desktop-main[href='/shop/men']"))).click();
		System.out.println("checking");
		driver.findElement(By.cssSelector("a[href=\"/men-jackets\"]")).click();
		System.out.println("check the element123");
		driver.findElement(By.cssSelector("span[data-colorhex=\"black\"]")).click();
		System.out.println("checking");
		// driver.close();
	}
}
//part of parameterization 
//Scenario: Passing a single parameter
// Given I have a number 67

//@Given("I have a number{int}")
//public void acceptOneNumber(int x) {
//}
