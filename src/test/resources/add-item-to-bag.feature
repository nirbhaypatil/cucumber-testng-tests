Feature:  Verify product item can be added in bag


  Scenario: Verify if a product can be added without selecting size
    Given User is on kids shorts page
    When product item is selected from displayed results
    And it is added to bag
    Then error should be displayed as "Please select a size"

  Scenario: verify selected product gets removed from bag
    Given User is on men jeans page
    When User selects a jeans products from displayed results
    And chooses a default size
    And adds it to a bag
    And removes it from bag
    Then bag should be empty

  Scenario: verify selected product get added in bag
    Given User is on men jeans page
    When User selects a jeans products from displayed results
    And chooses a default size
    And adds it to a bag
    Then selected item should get added in bag

  Scenario: verify only single size is allowed to select
    Given User is on men jeans page
    When User selects a jeans products from displayed results
    And chooses all available sizes
    Then only single size is selected

  @wip
  Scenario: verify coupon gets applied after adding item in bag
    Given User is on men jeans page
    When User selects a jeans products from displayed results
    And chooses a default size
    And adds it to a bag
    And applies at least a coupon from available options
    Then coupon discount should be applied in price details
