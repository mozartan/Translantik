@loc
Feature: As a store manager, I should be able to use the "Location" filter under the Fleet-Vehicles page

  Background:the user clicks on "Location" filter under Fleet-Vehicles module
    When the user clicks on "Location" filter under Fleet-Vehicles module

  @US014_AC01 @TRANS-1259
  Scenario: User can select "Location" filter under 'Fleet-Vehicles' module
    Then the "Location" filter should be selected

  @US014_AC02 @TRANS-1260
  Scenario: "Location" filter should provide the methods shown as below in the examples
    When the user clicks on "Location:All" button
    And the user clicks on default dropdown of the "Location" filter which is "Contains" dropdown
    Then the Methods should be seen as below
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

  @US014_AC03 @TRANS-1261
  Scenario: "Contains" method should give the results that contain the specified keyword
    When the user clicks on "Location:All" button
    And the user clicks on default dropdown of the "Location" filter which is "contains" dropdown
    When the user writes the "LAKE" keyword to "Contains" method input box and click update button
    Then the "Location" column results should contain the "LAKE" keyword

  @US014_AC04 @TRANS-1262
  Scenario: "Does Not Contain" method should give the results that does not contain the specified keyword
    When the user clicks on "Location:All" button
    And the user clicks on default dropdown of the "Location" filter which is "contains" dropdown
    And the user clicks on "does not contain" dropdown
    And the user writes the "CH" keyword to "does not contain" method input box and click update button
    Then the "Location" column results should not contain the "CH" keyword

  @US014_AC05 @TRANS-1263
  Scenario: "Starts With" method should give the results that starts with the specified keyword
    When the user clicks on "Location:All" button
    Given the user clicks on default dropdown of the "Location" filter which is "contains" dropdown
    And the user clicks on "starts with" dropdown
    And the user writes the "CH" keyword to "starts with" method input box and click update button
    Then the "Location" column results should start with the "CH" keyword

  @US014_AC06 @TRANS-1264
  Scenario: "Ends With" method should give the results that ends with the specified keyword
    When the user clicks on "Location:All" button
    And the user clicks on default dropdown of the "Location" filter which is "contains" dropdown
    And the user clicks on "ends with" dropdown
    And the user writes the "er" keyword to "ends with" method input box and click update button
    Then the "Location" column results should end with the "er" keyword

  @US014_AC07 @TRANS-1265
  Scenario: "Is Equal to" method should give the results that ends with the specified keyword
    When the user clicks on "Location:All" button
    And the user clicks on default dropdown of the "Location" filter which is "contains" dropdown
    And the user clicks on "Is Equal To" dropdown
    And the user writes the "FIONAPORT" keyword to "Is Equal To" method input box and click update button
    Then the "Location" column results should display "FIONAPORT" keyword