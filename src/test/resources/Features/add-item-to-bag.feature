Feature:  Verify product item can be added in bag


  Scenario: Verify if a product can be added without selecting size
    Given User is on kids shorts page
    When product item is selected from displayed results
    And it is added to bag
    Then error should be displayed as "Please select a size"

  Scenario: Verify without selecting item order can not be placed
    Given User is on men jeans page
    When User selects a jeans from displayed results
    And chooses a default size
    And adds it to a bag
    Then selected item should get added in bag
    When User
    
  Scenario: Verify selected product gets removed from bag
    Given User is on men jeans page
    When User selects a jeans from displayed results
    And chooses a default size
    And removes it from bag
    Then bag should be empty

  Scenario: Verify only single size is allowed to select
    Given User is on men jeans page
    When User selects a jeans from displayed results
    And chooses all available sizes
    Then only single size is selected

  Scenario: Verify coupon gets applied after adding item in bag
    Given User is on men jeans page
    When User selects a jeans from displayed results
    And chooses a default size
    And adds it to a bag
    And applies at least a coupon from available options
    Then coupon discount should be applied in price details

  Scenario: Verify delivery pin code can be entered
    Given User is on men jackets page
    When User selects a jacket from displayed results
    And chooses a default size
    And adds it to a bag
    And enters delivery pincode "411027"
    Then pincode "411027" should be visible on checkout page

  Scenario: Verify invalid phone number while adding item to whish list from bag
    Given User is on men jeans page
    When User selects a jeans from displayed results
    And chooses a default size
    And adds it to a bag
    Then selected item should get added in bag
    When User move it to wishilist
    Then User should be on login page
    When User enters invalid phone number
    Then error message "Authentication