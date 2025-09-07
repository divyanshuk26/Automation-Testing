Feature: Home Page validation

  Scenario: Verify Home Page sections
    Given I am on the Home Page
    Then the Programs menu should be displayed
    And the Services menu should be displayed
    And the Contact Us page link should be displayed

  Scenario: Verify Search Functionality
    Given I am on the Home Page
    When I search for "Tobacco"
    Then the search results page URL should contain "Tobacco"
