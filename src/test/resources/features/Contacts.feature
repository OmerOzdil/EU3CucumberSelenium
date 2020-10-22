Feature: Contacts Page
  @wip
  Scenario: Default page number
    Given the user is on the login page
    And the user enters driver information
    When the user navigates to "Customers" "Contacts"
    Then the default page number 1


  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  Scenario: login as a given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | user10      |
      | password  | UserUser123 |
      | firstname | Brenden     |
      | lastname  | Schneider   |
    Then the user should be able to login