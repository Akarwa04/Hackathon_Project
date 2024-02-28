Feature: Practo_Validate

  Scenario: Successful opening the practopage and chosing all the filters and take doctor name
    Given the user is on the practo page
    When the user enters credentials (city: "Bangalore" , speciality: "Dentist")
    And the user select patient stories
    And the user select the experience from the options
    And the user select the price and availability options from all filters
    Then the user click on the sort by option
    And the user should capture the first five doctor details

  Scenario: User is on Surgeries page
    Given the user click on surgeries
    When the user is on surgeries page he should scroll down
    Then the user should take all surgeries available in the list

  Scenario: User is on health & welness page
    Given the user click on corporate
    And the user click on health&wellness
    Then the user should fill the form with invalid details
    Then the user should fill the required form with valid details and click on schedule button
