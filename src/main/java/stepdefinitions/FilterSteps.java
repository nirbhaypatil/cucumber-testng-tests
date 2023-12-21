package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.*;
import org.testng.Assert;

import java.util.List;

public class FilterSteps {
    @When("product items are filtered by discount {string}")
    public void product_items_are_filtered_by_discount(String discount) throws InterruptedException {
        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.filterByDiscount(discount);
    }
    @Then("filtered items should have more than {string} discount")
    public void filtered_items_should_have_more_than_discount(String expectedDiscount) {
        SearchResultsPage searchResults = new SearchResultsPage();
        List<String> discounts = searchResults.getItemsDiscountPercentage();
        //Check first if discount list contains only % 
        SoftAssert softly = new SoftAssert();
        for( int i =0 ; i< discounts.size()-1;i++ ){
            softly.assertTrue(discounts.get(i).contains("%"),"Discount is not in % ");
        }
        for( int i =0 ; i< discounts.size()-1;i++ ){
            String actualDiscount = discounts.get(i).replaceAll("\\D+","");
            softly.assertTrue(Integer.parseInt(actualDiscount) >= Integer.parseInt(expectedDiscount),"Discount is not more than "+expectedDiscount);
        }
        softly.assertAll();
    }
}
