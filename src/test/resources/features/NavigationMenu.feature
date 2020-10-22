@AllFeature
Feature: Navigate to pages

  @Vehicles
  Scenario: Navigates to Fleet Vehicles
    Given the user is on the login page
    When the user enters the sales manager information
    And the user navigates to Fleet and vehicles page
    Then the user should land the Vehicle page

   @Campaigns
    Scenario: Navigates to Marketing Campaigns
      Given the user is on the login page
      When the user enters the sales manager information
      And the user navigates to Marketing to Campaigns page
      Then the user should land the Campaigns page

  @db
  Scenario: Navigates to Activities Calendar Events
    Given the user is on the login page
    When the user enters the sales manager information
    And the user navigates to Activities to Calendar Events page
    Then the user should land the Calenders page






