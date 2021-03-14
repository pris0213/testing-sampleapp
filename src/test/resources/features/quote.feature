Feature: Send Quote
  Allows the user to enter all info necessary to send a quote.

  @Functional @FirstScenario
  Scenario Outline: Fill vehicle form and move to the next step
    Given User is at the "Vehicle" form
    When User chooses brand "<brand>"
    And User enters the engine performance "<engine_performance>"
    And User enters the date of manufacture "<date_of_manufacture>"
    And User picks the number of seats "<number_of_seats>"
    And User chooses the fuel type "<fuel_type>"
    And User enters the payload "<payload>"
    And User enters the total weight "<total_weight>"
    And User enters the list price "<list_price>"
    And User enters the annual mileage "<annual_mileage>"
    And User goes to the "Insurant" form
    Then User is redirected to the "Insurant" form

    Examples:
    | brand         | engine_performance | date_of_manufacture | number_of_seats | fuel_type      | payload | total_weight | list_price | annual_mileage |
    | Mercedes Benz | 10                 | 03/02/2021          | 2               | Electric Power | 100     | 500          | 1000       | 10             |

  @Functional
  Scenario Outline: Fill insurant form and move to the next step
    Given User is at the "Insurant" form
    When User enters their first name "<first_name>"
    When User enters their last name "<last_name>"
    And User enters their date of birth "<dob>"
    And User picks their country "<country>"
    And User enters their zip code "<zipcode>"
    And User enters their occupation "<occupation>"
    And User enters their hobby "<hobby>"
    And User goes to the "Product" form
    Then User is redirected to the "Product" form

    Examples:
      | first_name | last_name | dob        | country | zipcode  | occupation | hobby        |
      | Desmond    | Hume      | 03/02/1990 | Brazil  | 30030030 | Farmer     | Cliff Diving |

  @Functional
  Scenario Outline: Fill product form and move to the next step
    Given User is at the "Product" form
    When User enters the start date "<start_date>"
    When User enters the insurance sum "<insurance_sum>"
    And User enters the damage insurance "<damage_insurance>"
    And User picks an optional product "<optional_product>"
    And User goes to the "Price" form
    Then User is redirected to the "Price" form

    Examples:
      | start_date | insurance_sum | damage_insurance | optional_product |
      | 12/14/2021 | 3000000       | Full Coverage    | Euro Protection  |

  @Functional
  Scenario Outline: Pick price option and move to the next step
    Given User is at the "Price" form
    When User picks the price option "<price>"
    And User goes to the "Quote" form
    Then User is redirected to the "Quote" form

    Examples:
      | price |
      | Gold  |

#  @Functional @LastScenario
#  Scenario Outline: Fill product form and move to the next step
#    Given User is at the "Product" form
##    When User enters the start date "<start_date>"
#    When User enters the insurance sum "<insurance_sum>"
#    And User enters the damage insurance "<damage_insurance>"
#    And User picks an optional product "<optional_product>"
#    And User goes to the "Product" form
#    Then User is redirected to the "Product" form
#
#    Examples:
#      | start_date | insurance_sum | damage_insurance | optional_product |
#      | 14/12/2021 | 3000000       | Full Coverage    | Euro Protection  |
