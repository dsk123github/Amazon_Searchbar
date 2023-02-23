Feature: Searchbar feature
  @smoke

  Scenario:  Verify that user is able to get the relevant product results as per the Search Query
    Given the User navigates to the Homepage
    When the User enters the product name
    Then the relevant product results should be displayed


 Scenario:  Verify that the User can able get the Product based on the brand name
  Given the User navigates to the Homepage
  When the User enters the brand name
  Then the user should get the relevant products based on the brand name

 Scenario: Verify that User is able to get the Error message ,when he enters the Invalid Product name
   Given the User navigates to the Homepage
   When the user should enter the invalid product name
   Then the user should be able get the error message

  Scenario: Verify that User is able to see the suggested product list in the dropdown list
    Given the User navigates to the Homepage
    When the User types the product name
    Then user is able to see the suggested product list in the Drop-down list

    Scenario: Verify that Cursor is displaying on clicking inside the Searchbar
      Given the User navigates to the Homepage
      When  the user clicks inside the Searchbar
      Then user is able to see the Cursor inside the searchbar

