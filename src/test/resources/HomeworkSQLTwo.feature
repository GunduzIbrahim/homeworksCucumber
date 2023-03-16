@dbQuery
Feature: Database Query

  Background:
    Given user connects to the database

  Scenario: user verified the total number of products in market table
    When user connects to the market table
    Then the total number of products verify

  Scenario: user verified the highest priced product in market table
    When user connects to the market table
    Then the price is verified by the highest product

  Scenario: user changes one of the product names in market table
    When user connects to the market table
    And one of the product name has changed

  Scenario: user finds average price of the product in market table
    When user connects to the market table
    And print average price of products

  Scenario: user changes column names in market table
    When user connects to the market table
    And print market table change column names

  Scenario: user prints product names to uppercase in market table
    When user connects to the market table
    And print market table with product names to uppercase

  Scenario: user prints product names to lowercase in market table
    When user connects to the market table
    And print market table with product names to lowercase

  Scenario: user prints first letter of product names to uppercase in market table
    When user connects to the market table
    And print market table with first letter of product names to uppercase

  Scenario: user prints sort products below a certain price by name and price in descending order in market table
    When user connects to the market table
    And print market table with sort products below a certain price by name and price in descending order