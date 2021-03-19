# As an internal user i would like to be able to create quotes

Feature: Quote Creation

  #------------------------------ Scenario : Quote Creation ------------------------------#

  @Underwriting
  @QuoteCreation

  Scenario Outline: Quote Creation

    Given I am logged in to Pure as "<subrole>"
    When I navigate to Quotes
     And I initiate a new quote for a new customer with location in "<state>" "<primaryAddress>" "<city>" "<zip>"
     And I create a quote
#    And I accept underwriting referrals
#    And I create required forms
    Examples:
      | subrole | state | primaryAddress                    | city            | zip   |
      | Field   | FL    | 12th Street, Miami Beach, FL, USA | Miami Beach     | 33139 |