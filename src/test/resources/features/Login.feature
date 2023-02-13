Feature: Login
  As a user, I should be able to login

  Scenario: User is able to login
    Given user is on login page
    When he enters his credentials
    Then he should be logged in