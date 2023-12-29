package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import pages.HomePage;
import pages.SearchResultsPage;

public class AddToProduct {
	@Given("Enter casio in search component")
	public void enter_casio_in_search_component() {
		HomePage homepage=new HomePage();
		homepage.enterProductToSearch("Casio");
		homepage.clickOnSearchMagnifier();
	  
	}

	@When("click on item")
	public void click_on_item() {
		
	   SearchResultsPage resultpage=new SearchResultsPage();
	   
	   resultpage.clickOnWatch();
	   Keyword keyword =new Keyword();
	   keyword.switchToNewTab();
	   
	}

	@Then("Verify itemDetails")
	public void verify_item_details() {
	   SearchResultsPage resultpage=new SearchResultsPage();
	   resultpage.getItemDetails();
	}
}
