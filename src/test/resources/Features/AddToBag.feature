
Feature: This feature verify Product Add To Bag funcationality
Scenario: verify when user searches smart watches men and product add to bag.
Given Enter Smart Watches Men in search component
When User click on search magnifier
When Product Must be add to the bag 
Then Check product to be added in the bag

Scenario: verify when user Product Add To WishList.
Given Enter Spark Shoes Men in search component
When User click on the search magnifier
When User click on the search product
Then Product Must be added to the WishList

Scenario: verify when user search Men Black Roadster Jackets
Given Hover on Men Element
When User click on Men Jackets
And User select Roadster Brand Checkbox
And User select Men Black Colour Checkbox
Then verify Roadster Product Titles contains 

Scenario: verify when user search Kids Red Colours Shirts Of Price Low To High
Given Hover on Kids Element
When User Click On Kids Shirts
And User select the Red Colour on Kids Color
Then Mouse hover on Sortby and select price range
