Feature: Contact Us Page validation

  Scenario: Verify Contact Us Page details
    Given I am on the Contact Us page
    Then the page title should be "CONTACT US - West Florida Area Health Education Center, Inc"
    And the phone number should be displayed
    And the address should be displayed
    And the email should be displayed
