@regression
Feature: Test login scenarios

  Scenario Outline: Login to the Pet Store
    Given user tries to log in with credentials "<username>", "<password>", and "<token>" expecting status code "<expected_status_code>"

    Examples:
      | username               | password | token                               | expected_status_code |
      | merchant@foodics.com   | 123456   | Lyz22cfYKMetFhKQybx5HAmVimF1i0xO    | 200                  |
      | merchant@foodics       | 123456   | Lyz22cfYKMetFhKQybx5HAmVimF1i0xO    | 500                  |
      | merchant@foodics.com   | 1234     | Lyz22cfYKMetFhKQybx5HAmVimF1i0xO    | 500                  |

    Scenario: call whoami endpoint using token
      When i call whoami end point using token retrieved from login
      Then i should get correct status code

#scenario (1) with 3 test cases for login scenario :
      #  first with valid email and password asset status code and token != null
      #  second with invalid email and correct password status code = 500 which is wrong implementation
      #  third with invalid password and correct email wrong implementation to should be 4xx as its client side error
  



#  scenario (2) extract token from login response and add it into header request auth :
#      please note structure of api quest and where to send token not clear as all responses redirects to redirect screen
#      so only asserted on status code

