Feature: Login

#  1. As a user, I should be able to login to the libeary app.

  @wip
  Scenario Outline: Verify both students and librarians can login
    Given the user login as a "<role>"
    Then the user is on "<page>" page
    Examples:
      | role      | page      |
      | student   | bookss     |
      | librarian | dashboard |



