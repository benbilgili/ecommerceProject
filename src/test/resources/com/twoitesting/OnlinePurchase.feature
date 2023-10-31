@RunThis
Feature: Online Purchase

  @Ignore
  Scenario Outline: I can apply a discount code and reduce the price of my order
    Given I am on the ecommerce login page
    And I have logged in using "ben.bilgili@2itesting.com" and "DavidRaya15"
    When I add an "<item>" to my basket
    And I apply discount code "discount code"
    Then The price should be reduced by 15%
    Examples:
      | item             |
      | Cap              |
      | Hoodie with Logo |
#      | Belt             |  -> element click intercepted


#  @Ignore
  Scenario Outline: I can verify my order number through my account after placing an order
    Given I am on the ecommerce login page
    And I have logged in using "ben.bilgili@2itesting.com" and "DavidRaya15"
    When I add an "<item>" to my basket
    And I complete the purchase
    Then I can view the order and order number
    Examples:
      | item             |
      | Cap              |
#      | Hoodie with Logo |
#      | Belt             |  -> element click intercepted