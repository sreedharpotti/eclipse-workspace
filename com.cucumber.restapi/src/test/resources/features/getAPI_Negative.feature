Feature: Testing REST API - Negative scenario

  Scenario: Send GET request to API with negative scenarios
    When I send GET request to "<URL>"
    Then the failed response status code should be <CODE>
    
 Examples:
  |CODE|URL        |
  |404 |http://www.anapioficeandfire.com/apis/houses?region=The Vale|
  |404 |https://www.anapioficeandfire.com/api/house?region=The Vale|
  |200 |http://www.anapioficeandfire.com/api/houses?region=The Vale@@@|