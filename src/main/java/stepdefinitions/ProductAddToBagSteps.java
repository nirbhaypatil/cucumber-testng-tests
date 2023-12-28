package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import pages.HomePage;
import pages.MainMenu;
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

	@Given("Hover on Men Element")
	public void hover_on_men_element() {
		MainMenu menu = new MainMenu();
		menu.hoverOn("Men");
	}

	@When("User click on Men Jackets")
	public void user_click_on_men_jackets() {
		MainMenu menu = new MainMenu();
		menu.clickOnMenuItem("jackets");

	}

	@When("User select Roadster Brand Checkbox")
	public void user_select_roadster_brand_checkbox() {
		SearchResultsPage results = new SearchResultsPage();
		results.selectRoadsterBrandCheckBox();
	}

	@When("User select Men Black Colour Checkbox")
	public void user_select_men_black_colour_checkbox() {
		SearchResultsPage results = new SearchResultsPage();
		results.selectMenBlackColourCheckBox();

	}

	@Then("verify Roadster Product Titles contains")
	public void verify_roadster_product_titles_contains(String pTitles) {
		SearchResultsPage results = new SearchResultsPage();
		results.verifyRoadsterProductTitlesContains("Roadster");
	}

	@Given("Hover on Kids Element")
	public void hover_on_kids_element() {
		MainMenu menu = new MainMenu();
		menu.hoverOn("Kids");

	}

	@When("User Click On Kids Shirts")
	public void user_click_on_kids_shirts() {
		MainMenu menu = new MainMenu();
		menu.clickOnKidsMenuItem("Shirts");
	}

	@When("User select the Red Colour on Kids Color")
	public void user_select_the_red_colour_on_kids_color() {
		SearchResultsPage results = new SearchResultsPage();
		results.selectKidsRedColourCheckBox();
	}

	@Then("Mouse hover on Sortby and select price range")
	public void mouse_hover_on_recommended_and_select_price_range() {
		SearchResultsPage results = new SearchResultsPage();
		results.mouseHoverOnPriceLowToHigh();
	}

}
