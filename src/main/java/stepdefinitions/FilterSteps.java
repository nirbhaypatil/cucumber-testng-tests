package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import org.testng.Assert;

public class FilterSteps {
    @When("product items are filtered by discount {string}")
    public void product_items_are_filtered_by_discount(String string) {

    }
    @Then("filtered items should have more than discount {string}")
    public void filtered_items_should_have_more_than_discount(String string) {

    }
}
