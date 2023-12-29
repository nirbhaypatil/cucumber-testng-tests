package pages;

import errors.InvalidMenuItemException;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import waits.WaitFor;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResultsPage {
	Keyword keywords = new Keyword();
	@FindBy(css = "ul.results-base li.product-base:first-child")
	public WebElement firstItem;

	@FindBy(css = "ul.results-base")
	public WebElement searchResult;

	@FindBy(css = "ul.results-base div.product-price")
	public List<WebElement> itemPrices;

	@FindBy(css = "div.sort-sortBy")
	public WebElement listSortBy;

	// @FindBy(css="ul.discount-list > li:nth-child(1) > label:nth-child(1) >
	// input:nth-child(1)")
	// public WebElement discountPerOption;

	@FindBy(css = "ul.discount-list li label")
	public List<WebElement> filterDiscountOptions;

	@FindBy(css = "span.product-discountPercentage")
	public List<WebElement> itemDiscountPercentage;

	@FindBy(css = "div.pdp-add-to-bag")
	public WebElement addToBag;

	@FindBy(css = "a.pdp-goToCart")
	public WebElement goToBag;

	@FindBy(css = "li.product-base:nth-child(1) > a:nth-child(3) > div:nth-child(2)")
	public WebElement sparkShoesImg;

	@FindBy(css = "div.pdp-add-to-wishlist")
	public WebElement addWishList;

	@FindBy(css = ".categories-list > li:nth-child(1) > label:nth-child(1)") // .categories-list > li:nth-child(1) >
																				// label:nth-child(1)
	public WebElement menRoadsterCheckBox;

	@FindBy(css = "span[data-colorhex=\"black\"]")
	public WebElement menBlackCheckBox;

	@FindBy(css = "li.product-base:nth-child(27) > a:nth-child(3) > div:nth-child(2) > h3:nth-child(1)")
	public List<WebElement> productTitles;

	private By productTitle = By
			.cssSelector("li.product-base:nth-child(27) > a:nth-child(3) > div:nth-child(2) > h3:nth-child(1)");

	@FindBy(css = "li.colour-listItem:nth-child(5) > label:nth-child(1)")
	public WebElement kidRedColourCheckBox;

	@FindBy(css = "div.sort-sortBy")
	public WebElement hoverOnSortby;

	@FindBy(css = ".sort-list > li:nth-child(6) > label:nth-child(1)")
	public WebElement priceLowToHigh;


	@FindBy(css = "h3[class=\"product-brand\"]")
	public WebElement casiowatch;

	@FindBy(css = "[class=\"index-rowValue\"]:nth-child(2)")
	public WebElement itemDetails;

	@FindBy(css = ".gender-list > li:nth-child(1)")
	public WebElement kidsFilter;

	@FindBy(css = "li.colour-listItem:nth-child(6)")
	public WebElement kidsRedColour;

	@FindBy(css = "li.colour-listItem:nth-child(2) > label:nth-child(1)")
	public WebElement whiteCheckBox;

	@FindBy(css = "img[title=\"Puma Unisex TRUCO IIl Football Non-Marking Shoes\"]")
	public WebElement enterImg;


	public SearchResultsPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public void selectFirstProduct() {
		Keyword keyword = new Keyword();
		firstItem.click();
		keyword.switchToNewTab();
	}

	public List<Integer> getPrices() {
		Keyword keyword = new Keyword();
		// To avoid StaleElementException
		Keyword.getDriver().navigate().refresh();
		List<Integer> prices = new ArrayList<>();
		for (WebElement itemPrice : itemPrices) {
			prices.add(Integer.parseInt(itemPrice.getText().split("Rs. ", -1)[1]));
		}
		return prices;
	}

	public void sortByPrices(String criteria) {
		Keyword keyword = new Keyword();
		keyword.hoverOn(listSortBy);
		List<WebElement> options = listSortBy.findElements(By.cssSelector("li label"));

		switch (criteria.toLowerCase()) {
		case "high to low":

			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("Price: High to Low")) {
					option.click();
					break;
				}
			}
			WaitFor.waitForElementToPresent(searchResult);
			break;
		case "low to high":
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("Price: Low to High")) {
					option.click();
					break;
				}
			}
			WaitFor.waitForElementToPresent(searchResult);
			break;
		default:
			throw new InvalidMenuItemException(criteria);
		}
	}

	/**
	 * This method allows to select radio button for discount
	 *
	 * @param discount "10% and above"
	 */
	public void filterByDiscount(String discount) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("10% and above", "10.0 TO 100.0");
		map.put("20% and above", "20.0 TO 100.0");
		map.put("30% and above", "30.0 TO 100.0");
		map.put("40% and above", "40.0 TO 100.0");
		map.put("50% and above", "50.0 TO 100.0");

		for (WebElement discountItem : filterDiscountOptions) {
			if (discountItem.findElement(By.cssSelector("input")).getAttribute("value")
					.equalsIgnoreCase(map.get(discount))) {
				// clicks discount item label , input item is not clickable.
				discountItem.click();
				break;
			}
		}
	}

	/**
	 * Returns discount in percentage terms
	 *
	 * @return List<String> e.g.{ '50%','20%'}
	 */
	public List<String> getItemsDiscountPercentage() {
		List<String> discounts = new ArrayList<String>();
		for (WebElement itemDiscountPercentage : itemDiscountPercentage) {
			discounts.add(itemDiscountPercentage.getText());
		}
		return discounts;
	}

	public void productAddToBag() {
		addToBag.click();
	}

	public void checkProductAddToBag() {
		goToBag.click();
	}

	public void clickToTheSparkShoesImg() {
		sparkShoesImg.click();
	}

	public void enterOnWishList() {
		addWishList.click();
	}

	public void selectRoadsterBrandCheckBox() {
		menRoadsterCheckBox.click();
	}

	public void selectMenBlackColourCheckBox() {
		WaitFor.waitForElementToBeClickable(menBlackCheckBox);
		menBlackCheckBox.click();
	}

	public List<String> getProductTitles() {
		WaitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		return keywords.getTexts(productTitles);
	}

	public void verifyRoadsterProductTitlesContains(String expectedtext) {
		List<String> titles = getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String title : titles) {
			softly.assertTrue(title.contains(expectedtext));
		}
		softly.assertAll();
	}

	public void selectKidsRedColourCheckBox() {
		// WaitFor.waitForElementToPresent(kidRedColourCheckBox);
		WaitFor.waitForElementToBeClickable(kidRedColourCheckBox);
		kidRedColourCheckBox.click();
	}

	public void mouseHoverOnPriceLowToHigh() {
		Actions act = new Actions(Keyword.getDriver());
		WaitFor.waitForElementToPresent(hoverOnSortby);
		act.moveToElement(hoverOnSortby).click().perform();

		;

		WaitFor.waitForElementToBeClickable(priceLowToHigh);
		act.moveToElement(priceLowToHigh);
		act.click().perform();
	}


	public void clickOnWatch() {
		casiowatch.click();
	}

	public void getItemDetails() {

		Keyword keyword = new Keyword();
		WaitFor.waitForElementToPresent(itemDetails);
		String display = itemDetails.getText();
		System.out.println(display);
		Assert.assertEquals(display, "Analogue");

	}


	public void selectKidsBoysFilter() {
		WaitFor.waitForElementToBeClickable(kidsFilter);
		kidsFilter.click();
	}

	public void clickOnRedColourCheckBox() {
		WaitFor.waitForElementToBeClickable(kidsRedColour);
		kidsRedColour.click();
	}

	public void selectWhiteCheckBoxOfPomaShoes() {
		whiteCheckBox.click();
	}

	public void clickOnPomaWhiteShoes() {
		WaitFor.waitForElementToBeClickable(enterImg);
		enterImg.click();
	}

}
