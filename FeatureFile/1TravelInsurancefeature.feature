Feature: Finding Travel Insurance For Two Students

  Scenario: Get Three Company names for the
    Given the user clicks on the policy bazar page
    When the user clicks the travel insurance
    And the user enters "destination" and select United Kingdom
    And the user clicks next after selecting destination
    And the user slecting the date
    And the user clicks next after selecting date
    And the user selects no of persons as two
    And the user selects age for the two students
    And the user clicks next after students selection
    And the user clicks no for medical issues
    And the user clicks next after no
    And the user enters "mobileno"
    And the user clicks viewplans
    And the user check student plans
    And the user select students and duration
    And the user clicks apply
    And the user select price as low to high
    And the user prints the first three companies details
    Then the user get back to home
