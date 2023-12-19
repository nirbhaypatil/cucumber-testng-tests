package com.myntra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.myntra.keywords.Keyword;
import com.myntra.waits.WaitFor;

public class SearchResultsPage {
	Keyword keyword = new Keyword();
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTitles;

	@FindBy(css = "img[alt=\\\"NOISE Olive Green ColorFit Icon Buzz Bluetooth Calling Smart Watch with Voice Assistance\\\"]")
	public WebElement searchTextBox;

	private By productTitle = By.cssSelector("h3.product-brand");

	public SearchResultsPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public List<String> getProductTitles() {
		WaitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		return keyword.getTexts(productTitles);
	}

	public void verifyProductTitlesContains(String expectedtext) {
		List<String> titles = getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String title : titles) {
			softly.assertTrue(title.contains(expectedtext));
		}
		softly.assertAll();
	}

	@FindBy(css = "input[value=\"Roadster\"]")
	public WebElement roadsterCheckBox;

	public void selectRoadsterCheckBox() {
		roadsterCheckBox.click();
	}

	@FindBy(css = "span[data-colorhex=\"blue\"]")
	public WebElement blackColourCheckBox;

	public void selectBlackColourCheckBox() {
		blackColourCheckBox.click();
	}

	@FindBy(css = "div.pdp-add-to-wishlist")
	public WebElement enterWishlist;

	public void clickOnTheWishList() {
		enterWishlist.click();
	}

}
