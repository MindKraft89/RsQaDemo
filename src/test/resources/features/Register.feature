@Register
Feature: Register
  As a user, I would like to register so I can order a Book

  Scenario: User is able to register (Create user)
    Given a user has no login yet
    When user registers himself
    Then he is able to access his profile