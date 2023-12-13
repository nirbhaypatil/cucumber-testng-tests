package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartCheckOutPage;
import pages.MainMenu;
import pages.ProductItemDetailsPage;
import pages.SearchResultsPage;
import org.testng.Assert;



public class BagSteps {

    @Given("User is on kids shorts page")
    public void goToKidsShorts(){
        MainMenu menu = new MainMenu();
        //go to kids -> shorts menu
        menu.hoverOn("kids");
        menu.clickOnMenuItem("Shorts");
    }

    @When("product item is selected from displayed results")
    public void productItemIsSelectedFromDisplayedResults() {
        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
    }

    @And("it is added to bag")
    public void itIsAddedToBag() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.addToBag();
    }

    @Then("error should be displayed as {string}")
    public void errorShouldBeDisplayedAs(String expectedError) {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        String errorActual = productItem.getProductItemError();
        Assert.assertEquals(expectedError,errorActual);
    }
    @Given("User is on men jeans page")
    public void user_is_on_men_jeans_page() {
        MainMenu menu = new MainMenu();
        menu.hoverOn("men");
        menu.clickOnMenuItem("Jeans");
    }

    @When("User selects a jeans products from displayed results")
    public void user_selects_a_jeans_products_from_displayed_results() {
        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
    }
    @When("chooses a default size")
    public void chooses_a_default_size() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectDefaultSize();
    }
    @When("adds it to a bag")
    public void adds_it_to_a_bag() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.addToBag();
    }

    @When("removes it from bag")
    public void removes_it_from_a_bag() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        bagPage.removeItemFromBag();
    }

    @Then("bag should be empty")
    public void bag_should_be_empty(){
        CartCheckOutPage bagPage = new CartCheckOutPage();
        Assert.assertTrue(bagPage.isCartEmpty());
    }
    @Then("selected item should get added in bag")
    public void selected_item_should_be_displayed_in_bag() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        Assert.assertEquals(productItem.getItemAddedInBag(),"1");
    }

}
