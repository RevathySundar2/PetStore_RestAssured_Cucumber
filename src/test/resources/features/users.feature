Feature: Creates User

  @smoke
  Scenario: New user creation
    Given Creating a new user
    When Entering new user details
    Then User created with status 200



