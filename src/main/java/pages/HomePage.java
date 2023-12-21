package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import keywords.Keyword;
import waits.WaitFor;
import waits.WaitFor1;


public class HomePage {
	@FindBy(css = "div.desktop-query>input[placeholder*='Search for']")
	public WebElement searchComponent;

	public void enterProductToSearch(CharSequence... productName) {
		searchComponent.sendKeys(productName);
		System.out.println("Entered product: " + productName + " to search");
	}

	@FindBy(css = "span.sprites-search")
	public WebElement searcgMagnifier;

	public void clickOnSearchMagnifier() {
		searcgMagnifier.click();
	}

	public HomePage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	@FindBy(css = "img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/24364440/2023/8/29/fd9b2361-9e13-42e2-940c-08786b6c5a541693293821741-Fire-Boltt-Unisex-Smart-Watches-9221693293821024-1.jpg\"]")
	public WebElement watchProduct;

	public void clickOnProduct() {
		watchProduct.click();
	}

	@FindBy(css = "div.pdp-add-to-bag")
	public WebElement addToBag;

	public void productAddToBag() {
		addToBag.click();
	}

	@FindBy(css = "span[data-reactid=\"905\"]")
	public WebElement destopBag;

	public void clickOnDestopBag() {
		destopBag.click();
	}

	@FindBy(css = "img[src=\"https://assets.myntassets.com/w_111,h_148,dpr_1.5625,q_60,c_limit,fl_progressive/h_148,q_60,w_111/v1/assets/images/24364440/2023/8/29/fd9b2361-9e13-42e2-940c-08786b6c5a541693293821741-Fire-Boltt-Unisex-Smart-Watches-9221693293821024-1.jpg\"]")
	public WebElement imageToTheBag;

	public void clickOnProductToTheBag() {
		imageToTheBag.click();
	}

	@FindBy(css = "a[style=\"border-bottom-color:#ee5f73;\"]")
	public WebElement hoverMen;

	public void clickOnMenItem() {
		hoverMen.click();
	}

	@FindBy(css = "a[data-reactid=\"41\"]")
	public WebElement menJackets;

	public void clickOnMenJackets() {
		menJackets.click();
	}

	private By clickOnProductJacketsWait = By.cssSelector("a[data-reactid=\"41\"]");

	public void elementToBeClickebleJackets() {
		WaitFor1 waitfor = new WaitFor1();
		waitfor.elementToBeClickeble(clickOnProductJacketsWait);
	}

	@FindBy(css = "a[data-index=\"2\"]")
	public WebElement hoverKids;

	public void clickOnKidsItems() {
		hoverKids.click();
	}

	private By clickOnProductKidsTshirtswait = By.cssSelector("li[data-reactid=\\\"344\\\"]");

	public void elementToBeClickebleOnKidsTshirts() {
		WaitFor1 waitfor = new WaitFor1();
		waitfor.elementToBeClickeble(clickOnProductKidsTshirtswait);
	}

	@FindBy(css = "li[data-reactid=\"344\"]")
	public WebElement kidsTshirts;

	public void clickOnKidsTshirts() {
		kidsTshirts.click();
	}

	@FindBy(css = "img[alt=\"BONKIDS Boys White Mickey Mouse Printed T-shirt\"]")
	public WebElement enterOnImage;

	public void clickOnSearchProductOfKidsTshirt() {
		enterOnImage.click();
	}

}
