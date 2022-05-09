@tags_filter
Feature:As a store manager, I should be able to use the "Tags" filter under the 'All Car' page

  Background:the user clicks on "Tags" filter under Fleet-Vehicles module
    When the user clicks on "Tag" filter under Fleet-Vehicles module

  @US13_AC1 @TRANS-1249
  Scenario: User can select "Tags" filter under 'Fleet-Vehicles' module
    Then the "Tags" filter should be selected

  @US13_AC2 @TRANS-1251
  Scenario: "Tags" filter should provide the methods shown as below in the examples
    When the user clicks on "Tags:All" button
    And the user clicks on default dropdown of the "Tags" filter which is "is any of" dropdown
    Then the Methods should be seen as below
      | Is Any Of     |
      | Is Not Any Of |

  @US13_AC3 @TRANS-1252
  Scenario: When user selects "Is any Of" method with "Compact" option, the table should include corresponding value
    When the user clicks on "Tags:All" button
    And the user clicks on default dropdown of the "Tags" filter which is "is any of" dropdown
    And the user selects Is any Of method with Compact option
    Then the table should include corresponding value

  @US13_AC4 @TRANS-1253
  Scenario: When the user selects "Is not any Of" method with "Compact" option, the table shouldn't include the corresponding value
    When the user clicks on "Tags:All" button
    And the user clicks on default dropdown of the "Tags" filter which is "is any of" dropdown
    And the user selects Is  not any Of method with Compact option
    Then the table shouldn't include corresponding value

  @US13_AC5 @TRANS-1254
  Scenario: When the user selects "Is not any Of" method with "Compact" and "Sedan", the table shouldn't include corresponding values
    When the user clicks on "Tags:All" button
    And the user clicks on default dropdown of the "Tags" filter which is "is any of" dropdown
    And the user selects Is  not any Of method with Compact option and Sedan option
    Then the table should not include corresponding value