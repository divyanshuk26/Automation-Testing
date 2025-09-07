Feature: Healthy Aging Form submission

  Scenario: Verify Healthy Aging Form submission
    Given user is on the Healthy Aging Form page
    When user enters the first name as "Divyanshu"
    And user enters the last name as "Kotangale"
    And user enters phone number as "7894561235"
    And user enters email as "cucumber@testng.com"
    And user selects all the programs
    And user selects county
    And user selects class format
    And user selects described as "a"
    And user enters Heard About Us as "Social Media"
    And user clicks on checkbox
    And user clicks on submit
    Then the form should get submitted
    And user should see a success message confirming submission
