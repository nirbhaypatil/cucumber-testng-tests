Feature:  Verify product item can be added in bag


Scenario: Verify if a product can be added without selecting size
  Given User is on kids shorts page
  When product item is selected from displayed results
  And it is added to bag
  Then error should be displayed as "Please select a size"

Scenario: verify selected product gets added in bag
  Given User is on men jeans page
  When User selects a jeans products from displayed results
  And chooses a default size
  And adds it to a bag
  Then selected item should be displayed in bag

