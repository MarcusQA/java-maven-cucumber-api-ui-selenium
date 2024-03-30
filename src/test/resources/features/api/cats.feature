Feature: Get information on cats

  Scenario: Get cat breeds
    When I request a list of cat breeds
    Then I see the first breed listed is "Abyssinian"
