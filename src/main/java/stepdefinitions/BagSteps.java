package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
