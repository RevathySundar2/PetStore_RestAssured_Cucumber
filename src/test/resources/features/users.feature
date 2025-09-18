@smoke
Feature: Creates User


  Scenario: New user creation
    Given Creating a new user
    When Entering new user details
    Then User created with status 200


  Scenario Outline: User creation with valid and invalid input
      Given Creating invalid users
      When Entering invalid users <username> and <phone>
      Then Assertions should fail

Examples:
  | username | phone|
  | 7345ASDF | 8956BDFFD |
  | 874@#$#@$ | 2347df@@# |

