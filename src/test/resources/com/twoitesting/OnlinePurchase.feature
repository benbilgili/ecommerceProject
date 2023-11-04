@RunThis
Feature: Online Purchase

  @Ignore
  Scenario Outline: I can apply a discount code and reduce the price of my order
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
    When I add an "<item>" to my basket
    And I complete the purchase
    Then I can view the order and order number
    Examples:
      | item             |
      | Cap              |
#      | Hoodie with Logo |
#      | Belt             |  -> element click intercepted