Feature: Bookstore
  As a user, I'd like to be able to search for a Book and at it

  Scenario: User can search for a book and add this
    Given user is logged in
    When user searches for book 'Git Pocket Guide'
    Then he can add this to his record