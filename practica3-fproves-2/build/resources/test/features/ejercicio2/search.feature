Feature: Main search

  Narrative:
  In order find available flights
  As a client of https://www.vueling.com/es
  I want to be able to search flights

  Scenario: Initial search
    Given I'm main page
    When I try to find a fly
      | origin    | destination | outboundDate | returnDate | passengers |
      | Barcelona | Almeria     | NEXT_WEEK    |            | 1          |
    Then I get available flight
