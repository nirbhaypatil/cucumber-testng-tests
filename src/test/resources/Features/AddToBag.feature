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