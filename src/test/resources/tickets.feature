Feature: Tickets booking system

  Scenario: API reservation check
    Given airports "RIX" and "SVO"
    Given personal info is:
      | first_name | Bohdan     |
      | last_name  | Stalinskyi |
      | discount   | Tester     |
      | adults     | 2          |
      | kids       | 2          |
      | bags       | 2          |
      | flight     | 14-05-2022 |

    And home page opened

    When we are selecting airports
    And pressing GoGoGo button

    Then selected airports appears
    When  we are filling in personal info
