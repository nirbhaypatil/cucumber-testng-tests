package pages;

import errors.InvalidMenuItemException;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResultsPage {
    @FindBy(css="ul.results-base li.product-base:first-child")
    public WebElement firstItem;

    @FindBy(css ="ul.results-base")
    public WebElement searchResult;

    @FindBy(css ="ul.results-base div.product-price")
    public List<WebElement> itemPrices;

    @FindBy(css="div.sort-sortBy")
    public WebElement listSortBy;

  //  @FindBy(css="ul.discount-list > li:nth-child(1) > label:nth-child(1) > input:nth-child(1)")
  //  public WebElement discountPerOption;

    @FindBy(css="ul.discount-list li label")
    public List<WebElement> filterDiscountOptions;

    @FindBy(css ="span.product-discountPercentage")
    public List<WebElement> itemDiscountPercentage;

    public SearchResultsPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    public void selectFirstProduct(){
        Keyword keyword = new Keyword();
        firstItem.click();
        keyword.switchToNewTab();
    }

    public List<Integer> getPrices(){
        Keyword keyword = new Keyword();
        // To avoid StaleElementException
        Keyword.getDriver().navigate().refresh();
        List<Integer> prices = new ArrayList<>() ;
        for ( WebElement itemPrice : itemPrices ) {
          prices.add( Integer.parseInt(itemPrice.getText().split("Rs. ",-1)[1]));
        }
       return prices;
    }

    public void sortByPrices(String criteria) {
       Keyword keyword = new Keyword();
       keyword.hoverOn( listSortBy);
       List<WebElement> options = listSortBy.findElements(By.cssSelector("li label"));

        switch(criteria.toLowerCase()){
           case "high to low":

               for ( WebElement option: options) {
                   if(option.getText().equalsIgnoreCase("Price: High to Low")) {
                       option.click();
                       break;
                   }
               }
               WaitFor.waitForElementToPresent(searchResult);
               break;
           case "low to high":
           for ( WebElement option: options) {
               if(option.getText().equalsIgnoreCase("Price: Low to High")) {
                   option.click();
                   break;
               }
           }
           WaitFor.waitForElementToPresent(searchResult);
           break;
           default:
               throw new InvalidMenuItemException(criteria);
       }
    }

    /**
     * This method allows to select radio button
     * for discount
     *
     * @param discount "10% and above"
     */
    public void filterByDiscount(String discount)  {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("10% and above","10.0 TO 100.0");
        map.put("20% and above","20.0 TO 100.0");
        map.put("30% and above","30.0 TO 100.0");
        map.put("40% and above","40.0 TO 100.0");
        map.put("50% and above","50.0 TO 100.0");

        for ( WebElement discountItem: filterDiscountOptions) {
            if(discountItem.findElement(By.cssSelector("input")).getAttribute("value").equalsIgnoreCase(map.get(discount))){
              //clicks discount item label , input item is not clickable.
              discountItem.click();
              break;
            }
        }
    }

    /**
     * Returns discount in percentage terms
     *
     * @return List<String> e.g.{ '50%','20%'}
     */
    public List<String> getItemsDiscountPercentage() {
        List<String> discounts = new ArrayList<String>() ;
        for ( WebElement itemDiscountPercentage : itemDiscountPercentage ) {
            discounts.add(itemDiscountPercentage.getText());
        }
        return discounts;
    }
}
