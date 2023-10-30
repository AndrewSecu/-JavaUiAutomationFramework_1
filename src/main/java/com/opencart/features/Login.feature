Feature: Login Related Test Cases

  @run
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the login form is populated with following details:
      | <email>    |
      | <password> |
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email                 | password       | affectedAttribute |
      | andrei.secu@gmail.com | The Password!1 | password          |
      | andreeail.com         | The Password1  | password          |