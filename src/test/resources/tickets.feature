Feature: Tickets booking system

  Scenario: API reservation check
    Given airports "RIX" and "SVO"
    And seat number is 22
    Given personal info is:
      | first_name | random     |
      | last_name  | Tester     |
      | discount   | none       |
      | adults     | 2          |
      | kids       | 2          |
      | bags       | 2          |
      | flight     | 14-05-2018 |

    And home page opened

    When we are selecting airports
    And pressing GoGoGo button

    Then selected airports appears
    When  we are filling in personal info
    And we are submitting form
    Then passenger name is shown
    When we are pressing Book btn
    And selecting seat
    And submitting seat

    When we are making final book
    Then sucessful message appears

    When We are requesting tickets data
    Then reservation exists in the list with correct data
