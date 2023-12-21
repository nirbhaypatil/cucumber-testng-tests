package Tests;

import org.testng.annotations.Test;

import keywords.Keyword;
import pages.HomePage;


public class PracticeTestCases {

	@Test
	public void verifyProductAddToBag() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Smart Watches Men");
		homepage.clickOnSearchMagnifier();
		homepage.clickOnProduct();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
		homepage.productAddToBag();
		homepage.clickOnDestopBag();
		homepage.clickOnProductToTheBag();
	}
}
