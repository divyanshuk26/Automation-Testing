Feature: My Account Page functionalities

  Scenario: Verify user registration
    Given I am on the My Account page
    When I register with valid details
    Then I should be registered successfully

  Scenario: Verify user login
    Given I am on the My Account page
    When I login with valid credentials
    Then I should be logged in successfully

  Scenario: Verify forgot password functionality
    Given I am on the My Account page
    When I request a password reset
    Then I should receive a reset confirmation
