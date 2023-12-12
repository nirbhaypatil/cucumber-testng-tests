package stepdefinitions;

import io.cucumber.java.en.*;
import pages.MainMenu;


public class SortProductSteps {

    @Given("User is on Mens tshirt page")
    public void user_is_on_mens_tshirt_page() {
        MainMenu menu = new MainMenu();
        //go to kids -> shorts menu
        menu.hoverOn("men");
        menu.clickOnMenuItem("t-shirts");
    }
    @When("User sort by price high to low")
    public void user_sort_by_price_high_to_low() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User should see all producted sorted in ascending order")
    public void user_should_see_all_producted_sorted_in_ascending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
