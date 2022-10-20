Feature: Google Website And View Site Details

  Scenario: user navigate to the google and search data
    Given user open the google browser
    When user enter the text to search
    And user click the search button
    Then user verify  search result

  Scenario: user verify the listed cloud services
    Given user navigate to the site
    When user view listed cloud services
    Then user verify the details of relavant cloud services And AWS Sites





