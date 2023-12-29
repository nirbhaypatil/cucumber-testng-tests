Feature: This feature verify search Product Kids Casual Shoes.
Scenario: verify when user search product Of Kids Casual Shoes Of Selected Price Range.
Given User hover on Kids Item
When User click on casual shoes
And User select a Boy Filter
And User select a Red Colour on Kids Colours
Then Verify when user select price Low to High
		
Scenario: verify user search Men Puma Sport Shoes.
Given Enter Puma Men Shoes on search component and click on search magnifier.
When User select a colour Checkbox.
And User click on product
Then verify check the product. 