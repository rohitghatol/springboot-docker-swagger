Feature: Second Scenario

  Scenario: Storing and Retrieving Customer
    When I store a new Customer[firstname="Dipesh",lastname="Rane"
    Then I expect to see Customer[firstname="Dipesh",lastname="Rane" in List of Customers
