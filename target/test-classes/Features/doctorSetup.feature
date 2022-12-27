Feature: To test Doctor Setup page visibility and functionality

  Scenario: After login suceessfully user move to doctor setup page
    Given User already navigated to the doctor setup page
    And Continue button for Setup A is visible
    When User presses the button
    Then User should navigate to Basic details page
