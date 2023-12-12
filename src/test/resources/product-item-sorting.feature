Feature: User can do product sorting


  Scenario: User can sort Mens Tshirt by ascending order
    Given User is on Mens tshirt page
    When User sort by price high to low
    Then User should see all producted sorted in ascending order