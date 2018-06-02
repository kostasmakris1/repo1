Feature: As a user I want to be able to navigate to different brand categoris and add products to basket

  Background:
    Given I am on the kurtgeiger home page

  Scenario:  View list of products for a selected brand
    When I select brand category from the header
    And I select a brand from the list
    Then I should see a list of products for the selected brand

