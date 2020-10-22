Feature: Contacts Page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters driver information
    When the user navigates to "Customers" "Contacts"
    Then the default page number 1