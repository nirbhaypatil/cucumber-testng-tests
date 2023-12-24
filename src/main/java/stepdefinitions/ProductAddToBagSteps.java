package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import pages.HomePage;
import pages.SearchResultsPage;

public class ProductAddToBagSteps {
	@Given("Enter Smart Watches Men in search component")
	public void enter_smart_watches_men_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Smart Watches Men");

	}

	@When("User click on search magnifier")
	public void user_click_on_search_magnifier() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@When("Product Must be add to the bag")
	public void product_must_be_add_to_the_bag() {
		HomePage homepage = new HomePage();
		homepage.clickOnProduct();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
		SearchResultsPage results = new SearchResultsPage();
		results.productAddToBag();
	}

	@Then("Check product to be added in the bag")
	public void check_product_to_be_added_in_the_bag() {
		SearchResultsPage results = new SearchResultsPage();
		results.checkProductAddToBag();
	}
	@Given("Enter Spark Shoes Men in search component")
	public void enter_spark_shoes_men_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Spark Shoes Men");

	}
	@When("User click on the search magnifier")
	public void user_click_on_the_search_magnifier() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@When("User click on the search product")
	public void user_click_on_the_search_product() {
		SearchResultsPage results = new SearchResultsPage();
		results.clickToTheSparkShoesImg();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
	}

	@Then("Product Must be added to the WishList")
	public void product_must_be_added_to_the_wish_list() {
		SearchResultsPage results = new SearchResultsPage();
		results.enterOnWishList();
	}

}
