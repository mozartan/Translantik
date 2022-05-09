
Feature: As a store manager, I should be able to use the filter menu

  @TRANS-1204
  Scenario: "Manage Filter" button should be hidden by default.
    Then filter button is hidden

  @TRANS-1206
  Scenario: When a user clicks on the filter icon, the "Manage Filter" button should be visible
    When the user clicks on filter button
    Then manage filter button is visible

  @TRANS-1207
  Scenario: User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
    Given the user clicks on filter button
    When the user clicks on manage filter button
    Then all names under manage filters menu are clickable

  @TRANS-1213
  Scenario: User can see the corresponding filter option after typing the filter name.
    Given the user clicks on filter button
    When the user clicks on manage filter button
    Then user enters filter name on the filter input box and corresponding name is displayed

  @TRANS-1214
  Scenario: User can apply multiple filters at the same time.
    Given the user clicks on filter button
    When the user clicks on manage filter button
    And the user clicks 5 filters
    Then filtered names are displayed on the filter menu place

  @TRANS-1215
  Scenario: User removes all filters by clicking on the reset icon.
    Given the user clicks on filter button
    When the user clicks on manage filter button
    And the user clicks 5 filters
    And the user clicks reset button
    Then all filters are gone


















