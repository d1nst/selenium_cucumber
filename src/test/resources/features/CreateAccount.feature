Feature: New Account

  Scenario: Create a new account
    Given I am an user navigating to homepage
    When I click on Create Account button
    And I complete the form with desired values
    Then New account is created