Feature:  Verify product item can be added in bag


Scenario: Verify if a product can be added without selecting size
  Given User is on kids shorts page
  When product item is selected from displayed results
  And it is added to bag
  Then error should be displayed as "Please select a size"
