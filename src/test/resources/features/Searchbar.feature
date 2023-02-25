Feature: Searchbar feature

  Scenario:  Verify that user is able to get the relevant product results as per the Search Query
    Given the User navigates to the Homepage
    When the User enters the product name
    Then the relevant product results should be displayed


 Scenario:  Verify that the User can able get the Product based on the brand name
  Given the User navigates to the Homepage
  When the User enters the brand name
  Then the user should get the relevant products based on the brand name


  Scenario: Verify that the Amazon search box height is as per specification
    Given the User navigates to the Homepage
    Then search box height should be as per specification

  Scenario: Verify that the Amazon search box width is as per specification
    Given the User navigates to the Homepage
    Then search box width should be as per specification

  Scenario Outline: : Verify that user should get the relevant results when he enters the Incorrect product name
        Given the User navigates to the Homepage
        When user enters "<product name>" in the search bar
        Then User Should display the relevant "<product name>"
        Examples:
        |  product name    |
        |   sarreys        |
        |   red dressid    |


