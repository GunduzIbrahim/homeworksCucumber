@dbQuery1
Feature: Database Query

  Background:
    Given user connects to the employees database

  Scenario: user prints data with even id's last digit in employees table
    When user connects to the employees table
    And print employees table with even id's last digit

  Scenario: user finds total number of rows of employees table
    When user connects to the employees table
    And total number of rows of employees table is found

  Scenario: user finds maximum salary of employees table
    When user connects to the employees table
    And maximum salary is found

  Scenario: user finds second maximum salary of employees table
    When user connects to the employees table
    And second maximum salary is found

  Scenario: user finds all the information of the row with the maximum salary in employees table
    When user connects to the employees table
    And all the information of the row with the maximum salary is found

  Scenario: user finds all the information of the row with the second maximum salary in employees table
    When user connects to the employees table
    And all the information of the row with the second maximum salary is found