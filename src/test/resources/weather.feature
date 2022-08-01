Feature: Testing Weather API

  Scenario: Checking weather for the city
    Given city id : 524901
    When We are requesting weather data
    Then  coords are:
      | lon | 145.77 |
      | lat | -16.92 |

    And weather are:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |
    And base is "stations"

    And main are:
      | temp     | 300 |
      | pressure | 1007   |
      | humidity | 74     |
      | temp_min | 300.15 |
      | temp_max | 300.15 |
    And visibility : 10000
    And wind are :
      | speed | 3.6 |
      | deg   | 160 |
    And clouds are :
      | all | 40 |
    And dt : 1485790200
    And sys are :
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |
    And id are : 2172797
    And name is : "Cairns"
    Then cod is 200


