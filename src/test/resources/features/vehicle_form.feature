Feature: Vehicle Form
  Allows the user to enter all info regarding their vehicle.

  @functional
  Scenario Outline: Fill vehicle form and move to the next step
    Given User is at the "Vehicle" form
    When User chooses brand "<brand>"
#    And User enters the "<engine_performance>"
#    And User enters the "<date_of_manufacture>"
#    And User picks the "<number_of_seats>"
#    And User chooses "<right_hand>" drive
#    And User chooses "<fuel_type>"
#    And User enters "<payload>"
#    And User enters "<total_weight>"
#    And User enters "<list_price>"
#    And User enters "<plate>" number
#    And User enters "<annual_mileage>"
    And User goes to the "Insurant" form
    Then User is redirected to the "Insurant" form

    Examples:
    | brand         | engine_performance | date_of_manufacture | number_of_seats | right_hand | fuel_type      | payload | total_weight | list_price | plate   | annual_mileage |
    | Mercedes Benz | 10                 | 03/02/2021          | 2               | yes        | Electric Power | 100     | 500          | 1000       | ABC0000 | 10             |
