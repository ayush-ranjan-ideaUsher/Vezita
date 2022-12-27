Feature: To test signup functionality

  Scenario Outline: To test signup process
    Given Browser is still open
    And User moved to login page
    When User move from login page to signup page
    And user inputs non registered "<email>" and "<password>"
    And user input same "<password>" to confirm password field also select privacy checkbox
    Then user should get prompt

    Examples: 
      | email                    | password |
      | newregister0@yopmail.com | 12345678 |
