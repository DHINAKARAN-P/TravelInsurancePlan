Feature: Finding Car Insurance Quote

  @now
  Scenario: Checking the form whether wrong email entered then working properly or not
    Given the user is on the policy bazar page
    When the user click on the car insurance
    And the user click on buying new car
    And the user select city as delhi
    And the user select area in delhi
    And the user select company as volkswagon
    And the user select the car name
    And the user select the fuel type
    And the user select the model as highline plus
    And the user enter Invalid email "name" Name "Email" Email "mobile" MobileNo
    And the user enter valid  email "name" Name  "Email" Email "mobile" MobileNo
    And the user enters the details click on the viewprices
    And the user click the registration in next seven days
    And the user enters the car price
    And the  user clicks on the submit button
    And the user clicks first insurance
    And the user prints the car insurance quote
    Then the user return to home
