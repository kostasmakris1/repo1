Feature: As a user I want to be able to navigate to different brand categoris and add products to basket

  Background:
    Given I am on the kurtgeiger home page for "es"

  Scenario:  View list of products for a selected brand
    When I select "/shop-by-brand" category from the header
    And I select brand "Dolce & Gabbana" from the list
    Then I should see a list of products for the selected brand "Dolce & Gabbana"

  Scenario:  Add item to basked and proceed to checkout
    When I select "/men/shoes" category from the header
    And I add random product to basket
    Then product is ready for checkout
