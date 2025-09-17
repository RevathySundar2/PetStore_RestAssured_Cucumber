Feature: Creates list of users

  @smoketest
  Scenario: New user creation
    Given Creating a new user
    When Entering new user details
    Then User created with status 200

#    Scenario: Get user details
#      Given Read the user details
#      When Providing the username
#      Then User returned with status 200