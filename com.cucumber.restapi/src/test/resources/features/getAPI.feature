Feature: Testing REST API

  Scenario: Send GET request to API
    When I send GET request to "http://www.anapioficeandfire.com/api/houses?region=The Vale"
    Then the response status code should be 200
    Then the response region contains "The Vale"