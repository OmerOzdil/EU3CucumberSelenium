Feature: Contacts Page

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

  Scenario Outline: login as a given user <userType>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <userType>  |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login

    Examples:
      | userType       | firstName | lastName  |
      | user101         | Brenden   | Schneider |
      | storemanager85 | Stephan   | Haley     |

    @wip @db
    Scenario Outline: Contacts test with email
      Given  the user logged in as "salesmanager"
      And  the user navigates to "Customers" "Contacts"
      When the user clicks the "<email>" from contacts
      Then the information for "<email>" should be same with database

      Examples:
      |email|
      |mbrackstone9@example.com|
      |mike.jorden@hotmail.com |



