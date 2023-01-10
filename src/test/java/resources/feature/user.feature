Feature: Testing different request on the petstore application

  Scenario Outline: As a user I am registering new user detail
    Given Petstore app is running
    When I create a new user by providing userID "<id>" username "<username>" firstName "<firstName>" lastName "<lastName>" email "<email>" password "<password>" phone "<phone>" userStatus "<userStatus>"
    Then user must get back a valid status code 200
    Examples:
      | id  | username | firstName | lastName | email              | password   | phone       | userStatus |
      | 786 | HarryP   | Harry     | Potter   | H.Potter@gmail.com | abc123   | 012345678 | 1          |

  Scenario: As a user I am getting detail of new user
    When I send GET request for userID "<id>"
    Then I should get back a valid status code 200

  Scenario Outline: As a user I am updating user detail
    When I update user by providing userID "<id>" username "<username>" firstName "<firstName>" lastName "<lastName>" email "<email>" password "<password>" phone "<phone>" userStatus "<userStatus>"
    Then I should get a valid status code 200
    Examples:
      | id  | username | firstName | lastName   | email                  | password   | phone       | userStatus |
      | 786 | HarryP   | Harryp    | Potter | Harry.Potter@gmail.com | abc123 | 012345678 | 1          |

  Scenario: As user I am deleting user detail
    When I send delete request by userID "<id>"
    Then user get deleted and get status code 200
