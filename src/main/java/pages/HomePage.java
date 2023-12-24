package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.Keyword;


public class HomePage {
	@FindBy(css = "div.desktop-query>input[placeholder*='Search for']")
	public WebElement searchComponent;
	
	@FindBy(css = "span.sprites-search")
	public WebElement searcgMagnifier;
	
	@FindBy(css = "img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/24364440/2023/8/29/fd9b2361-9e13-42e2-940c-08786b6c5a541693293821741-Fire-Boltt-Unisex-Smart-Watches-9221693293821024-1.jpg\"]")
	public WebElement watchProduct;
	
	@FindBy(css = "a[data-group=\"men\"]")
	public WebElement hoverMen;
	
	@FindBy(css = "a[data-reactid=\"41\"]")
	public WebElement menJackets;
	
	@FindBy(css = "a[data-group=\"kids\"]")
	public WebElement hoverKids;
	
	@FindBy(css = "a[data-reactid=\"347\"]")
	public WebElement kidsShirts;

	
	public HomePage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void enterProductToSearch(CharSequence... productName) {
		searchComponent.sendKeys(productName);
		System.out.println("Entered product: " + productName + " to search");
	}
	
	public void clickOnSearchMagnifier() {
		searcgMagnifier.click();
	}
	
	public void clickOnProduct() {
		watchProduct.click();
	}
	
		
	public void clickOnMenItem() {
		hoverMen.click();
	}

	public void clickOnMenJackets() {
		menJackets.click();
	}
	public void clickOnKidsItems() {
		hoverKids.click();
	}
	
	public void clickOnKidsShirts() {
		kidsShirts.click();
	}
	
//	private By clickOnProductJacketsWait = By.cssSelector("a[data-reactid=\"41\"]");
//
//	public void elementToBeClickebleJackets() {
//		WaitFor1 waitfor = new WaitFor1();
//		waitfor.elementToBeClickeble(clickOnProductJacketsWait);
//	}
	
//	private By clickOnProductKidsTshirtswait = By.cssSelector("li[data-reactid=\\\"344\\\"]");
//	
//	public void elementToBeClickebleOnKidsTshirts() {
//		WaitFor1 waitfor = new WaitFor1();
//		waitfor.elementToBeClickeble(clickOnProductKidsTshirtswait);
//	}
	
	@FindBy(css = "img[alt=\"BONKIDS Boys White Mickey Mouse Printed T-shirt\"]")
	public WebElement enterOnImage;
	
	public void clickOnSearchProductOfKidsTshirt() {
		enterOnImage.click();
	}
}