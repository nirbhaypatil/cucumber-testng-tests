package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.MainMenu;
import pages.SearchResultsPage;

import java.util.List;

public class SortProductSteps {

    @Given("User is on mens tshirt page")
    public void user_is_on_mens_tshirt_page() {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("T-Shirts");
    }

    @Then("tshirts should be displayed in {string} order by prices")
    public void tshirts_should_be_displayed_in_descending_order_by_prices(String order) {

        SearchResultsPage searchResults = new SearchResultsPage();
        List<Integer> prices =  searchResults.getPrices();
        SoftAssert softly = new SoftAssert();

        switch (order.toLowerCase()) {

            case "descending":
                for( int i =0 ; i< prices.size()-1;i++ ){
                    softly.assertTrue(prices.get(i).compareTo(prices.get(i+1)) >= 0,"Prices not in high to low order.");
                }

                softly.assertAll();
                break;
            case "ascending":
                for( int i =0 ; i< prices.size()-1;i++ ){
                    softly.assertTrue(prices.get(i).compareTo(prices.get(i+1)) <= 0,"Prices not in low to high order.");
                }
                softly.assertAll();
                break;
        }
    }

    @When("product items are sorted by {string}")
    public void product_items_are_sorted_by(String criteria) {
        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.sortByPrices(criteria);
    }
}
