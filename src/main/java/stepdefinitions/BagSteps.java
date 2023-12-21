package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
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
    @Given("User is on men jackets page")
    public void user_is_on_men_jackets_page() {
        MainMenu menu = new MainMenu();
        menu.hoverOn("men");
        menu.clickOnMenuItem("jackets");
    }
    @When("User selects a jacket from displayed results")
    public void user_selects_a_jacket_from_displayed_results() {
        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
    }
    @When("enters delivery pincode {string}")
    public void enters_delivery_pincode(String pincode) {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        bagPage.enterPinCode(pincode);
    }
    @Then("pincode {string} should be visible on checkout page")
    public void pincode_should_be_visible_on_checkout_page(String pincode) {
        CartCheckOutPage bagPage = new CartCheckOutPage();
        Assert.assertTrue(bagPage.getDeliverToPinCode().contains(pincode));
    }

    @When("User selects a jeans from displayed results")
    public void user_selects_a_jeans_from_displayed_results() {
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


    @When("chooses all available sizes")
    public void chooses_all_available_sizes() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectAllSizes();
    }
    @Then("only single size is selected")
    public void only_single_size_is_selected() {
        //Verify only single size is selected.
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        Assert.assertEquals(productItem.getTotalSizesSelected(),1);
    }

    @When("applies at least a coupon from available options")
    public void applies_at_least_a_coupon_from_available_options() {
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        bagPage.applyCoupon();
        ApplyCouponPage coupon = new ApplyCouponPage();
        coupon.clickApplyCoupon();
    }

    @Then("coupon discount should be applied in price details")
    public void coupoun_discount_should_be_applied_in_price_details() {
        CartCheckOutPage bagPage = new CartCheckOutPage();
        Assert.assertTrue(bagPage.isCouponApplied());
    }
}
