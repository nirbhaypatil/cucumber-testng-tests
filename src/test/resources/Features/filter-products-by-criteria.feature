Feature:  Verify product items can be filtered by criteria

  @wip
  Scenario Outline: Verify if products items can be sorted by discount range
    Given User is on mens tshirt page
    When product items are filtered by discount "<range>"
    Then filtered items should have more than "<percentage>" discount

  Examples:
      | range         | percentage |
      | 10% and above | 10         |
      | 20% and above | 20         |