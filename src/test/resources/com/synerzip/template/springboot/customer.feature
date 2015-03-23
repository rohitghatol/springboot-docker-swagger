Feature: First Scenario

  Scenario: Storing and Retrieving Customer
    When I store a new Customer[firstname="Rohit",lastname="Ghatol"
    Then I expect to see Customer[firstname="Rohit",lastname="Ghatol" in List of Customers
