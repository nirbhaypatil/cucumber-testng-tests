package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import pages.HomePage;
import pages.MainMenu;
import pages.ProductItemDetailsPage;
import pages.SearchResultsPage;

public class KidsShoesSteps {
	@Given("User hover on Kids Item")
	public void user_hover_on_kids_item() {
		MainMenu menu = new MainMenu();
		menu.hoverOn("Kids");
	}

	@When("User click on casual shoes")
	public void user_click_on_casual_shoes() {
		MainMenu menu = new MainMenu();
		menu.clickOnKidsMenuItem("Casual Shoes");
	}

	@When("User select a Boy Filter")
	public void user_select_a_boy_filter() {
		SearchResultsPage results = new SearchResultsPage();
		results.selectKidsBoysFilter();

	}

	@When("User select a Red Colour on Kids Colours")
	public void user_select_a_red_colour_on_kids_color() {
		SearchResultsPage results = new SearchResultsPage();
		results.clickOnRedColourCheckBox();

	}

	@Then("Verify when user select price Low to High")
	public void verify_when_user_select_price_low_to_high() {
		SearchResultsPage results = new SearchResultsPage();
		results.mouseHoverOnPriceLowToHigh();
	}

	@Given("Enter Puma Men Shoes on search component and click on search magnifier.")
	public void enter_puma_men_shoes_on_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Puma Men Shoes");
		homepage.clickOnSearchMagnifier();
	}

	@When("User select a colour Checkbox.")
	public void user_select_a_colour_checkbox() {
		SearchResultsPage results = new SearchResultsPage();
		results.selectWhiteCheckBoxOfPomaShoes();
	}

	@When("User click on product")
	public void user_click_on_product() {
		SearchResultsPage results = new SearchResultsPage();
		results.clickOnPomaWhiteShoes();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
	}

	@Then("verify check the product.")
	public void verify_check_the_product() {
		ProductItemDetailsPage productPage = new ProductItemDetailsPage();
		productPage.getPomaShoesText();
	}
}
