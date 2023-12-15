Feature:  Verify product item can be sorted in ascending or descending order

  @wip
  Scenario: Verify if a product can be added without selecting size
    Given User is on mens tshirt page
    When product items are sorted by high to low
    Then tshirts should be displayed in descending order by prices

  @wip
  Scenario: verify selected product gets removed from bag
    Given User is on mens tshirt page
    When product items are sorted by low to high
    Then tshirts should be displayed in ascending order by prices
