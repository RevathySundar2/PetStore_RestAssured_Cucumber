@regression @smoketest
Feature: File for creating multiple users
  Scenario: Create 10 random users
    Given I hit the create user url
    When I want to create 10 random users
    Then 10 random users created successfully
