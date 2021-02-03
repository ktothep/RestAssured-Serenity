Feature: Sample Serenity Feature
  Scenario: Getting Employee Information
    When User hits the "/create" endpoint
    Then Response should not be null
    And Status code should be "200"