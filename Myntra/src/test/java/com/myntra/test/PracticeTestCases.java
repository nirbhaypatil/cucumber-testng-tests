package com.myntra.test;

import org.testng.annotations.Test;

import com.myntra.keywords.Keyword;
import com.myntra.pages.HomePage;
import com.myntra.pages.SearchResultsPage;


public class PracticeTestCases {
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

	@Test
	public void verifySearchResultMenBlackRoadsterJackets() {
		HomePage homepage = new HomePage();
		homepage.clickOnMenItem();
		homepage.elementToBeClickebleJackets();
		homepage.clickOnMenJackets();
		SearchResultsPage results = new SearchResultsPage();
		results.selectRoadsterCheckBox();
		results.selectBlackColourCheckBox();

	}

	@Test
	public void verifySearchProductAddToWishList() {
		HomePage homepage = new HomePage();
		homepage.clickOnKidsItems();
		System.out.println("click");
		homepage.elementToBeClickebleOnKidsTshirts();
		System.out.println("click111");
		homepage.clickOnKidsTshirts();
		System.out.println("click on Tshirts");
		homepage.clickOnSearchProductOfKidsTshirt();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
		SearchResultsPage results = new SearchResultsPage();
		results.clickOnTheWishList();
	}

}
