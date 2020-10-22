
@login
Feature: Users should be able to login
  @driver @VYT-123
  Scenario: Login as a driver
    Given the user is on the login page
    When the user enters driver information
    Then the user should be able to login
  @salesmanager
  Scenario: Login as a sales manager
    Given the user is on the login page
    When the user enters the sales manager information
    Then the user should be able to login
  @storemanager
  Scenario: Login as a store manager
    Given the user is on the login page
    When the user enters the store manager information
    Then the user should be able to login

       #homework
  @wip
  Scenario: Login Dynamically
    Given the user is on the login page
    When the user logged in as "salesmanager"
    And the user should be able to login
    Then the title contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle differnet usertypes

