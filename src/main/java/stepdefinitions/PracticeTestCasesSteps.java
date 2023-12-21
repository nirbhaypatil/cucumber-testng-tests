package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import pages.HomePage;

public class PracticeTestCasesSteps {
	@Given("Enter Smart Watches Men in search component")
	public void enter_smart_watches_men_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Smart Watches Men");
	}

	@When("User clicl on search magnifier")
	public void user_clicl_on_search_magnifier() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();
	}

	@Then("Product Must be add to the bag")
	public void product_must_be_add_to_the_bag() {
		HomePage homepage = new HomePage();
		homepage.clickOnProduct();
		Keyword keyword = new Keyword();
		keyword.handleWindows();
		homepage.productAddToBag();
	}
}
