@LoginProfile
Feature: Login Profile
  Background:
    Given Launch the website

  Scenario: Login to the Site
    Given I navigate to login page
    When I enter account details
      | email                | password    |
      | divakar26            | January1#1  |
      | divakar26gmail.com   | January1#1  |
      | divakar26@gmail      | January1#1  |
    Then I click on Sign In button


  Scenario Outline: Invalid Login Scenario
    Given I navigate to login page
    When I enter email address as "<email>"
    And  I enter password as "<password>"
    And I click on Sign In button
    Then I should see error message

    Examples:
      | email                | password    |
      | divakar26@gmail.com  | January1#1  |

  Scenario: Login Error Scenario for all Empty Fields
    Given I navigate to login page
    When I click on Sign In button
    Then I should see inline error messages for email and password

  Scenario Outline: Login Error Scenario for Password Empty Field
    Given I navigate to login page
    When I enter email address as "<email>"
    And I click on Sign In button
    Then I should see inline error messages for password

    Examples:
      | email                |
      | divakar26@gmail.com  |

  Scenario Outline: Login Error Scenario for Email Empty Field
    Given I navigate to login page
    When  I enter password as "<password>"
    And I click on Sign In button
    Then I should see inline error messages for email

    Examples:
      | password             |
      | January1#1           |

  Scenario Outline: Login Error Scenario for Invalid Email Address
    Given I navigate to login page
    When I enter email address as "<email>"
    And  I enter password as "<password>"
    And I click on Sign In button
    Then I should see inline error messages for invalid email

    Examples:
      | email                | password    |
      | divakar26            | January1#1  |
      | divakar26gmail.com   | January1#1  |
      | divakar26@gmail      | January1#1  |