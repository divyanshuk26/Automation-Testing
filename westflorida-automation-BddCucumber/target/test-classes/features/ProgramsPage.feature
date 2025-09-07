Feature: Programs Page validation

  Scenario: Verify all Programs pages open correctly
    Given I am on the Programs menu
    When I open each program one by one
    Then each program page should load successfully
