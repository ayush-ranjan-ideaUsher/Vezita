Feature: To test login functionality

  Scenario Outline: To test login functionality with correct credentials
    Given Browser is open
    And user has provided the url of login page
    When User inputs "<email>" and "<password>"
    And Press the login button
    Then User should navigate to profile verification page

    Examples: 
      | email                    | password |
      | vezitadocter@yopmail.com | 12345678 |
      | doctor1@yopmail.com      | 12345678 |
      | newregister0@yopmail.com | 12345678 |
      | newregister1@yopmail.com | 12345678 |
      | newregister2@yopmail.com | 12345678 |
      | newregister3@yopmail.com | 12345678 |
      | newregister4@yopmail.com | 12345678 |
      | newregister5@yopmail.com | 12345678 |
