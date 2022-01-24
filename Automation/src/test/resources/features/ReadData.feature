@ReadData
  Feature: Read Data
    Scenario Outline: Read Data
      Given I read Customer Data for "<customer>"

      Examples:
      | customer   |
      | Lakshay    |
      | Virender   |