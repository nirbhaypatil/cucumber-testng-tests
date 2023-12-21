Feature:  Verify product item can be sorted in ascending or descending order

  @wip
  Scenario Outline: Verify if list of products can be sorted
    Given User is on mens tshirt page
    When product items are sorted by "<criteria>"
    Then tshirts should be displayed in "<order>" order by prices
    Examples:
      | criteria    | order      |
      | high to low | descending |
      | low to high | ascending  |


