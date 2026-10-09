


Feature: Login functionality

  @smoke
  Scenario: Verify login page is displayed
    Given the user opens the application
    When the user clicks the Signup Login link
    Then the login page should be displayed
