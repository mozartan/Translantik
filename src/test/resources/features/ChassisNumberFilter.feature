@chassisFilter
Feature: The user can use the "Chassis Number" filter under the 'All Car' page

   #@TRANS-1241
  Background:
    When the user clicks on filter button
    And the user clicks on manage filter button
    And the user clicks on Chassis Number checkbox

  @US010_AC1 @TRANS-1242
  Scenario: User can select "Chassis Number" filter under 'Fleet-Vehicles' module
    Then the Chassis Number checkbox should be selected

  @US010_AC2 @TRANS-1243
  Scenario: "Chassis Number" filter should provide desired the methods
    And the user clicks on Chassis Number All button
    And the user clicks on dropdown menu
    Then Chassis Number filter should provide the methods shown as below
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |

  @US10_AC5 @TRANS-1244
    Scenario: When the user selects the "More than" method with numeric values, the results should be more than the specified value
      And the user clicks on Chassis Number All button
      And the user clicks on dropdown menu
      And the user clicks More Than button
      And enter numeric values
      And click update button
      Then the results should be more than specified value

    @US10_AC6 @TRANS-1245
    Scenario: When the user selects the "Less than" method with numeric values, the results should be less than the specified value
      And the user clicks on Chassis Number All button
      And the user clicks on dropdown menu
      And the user clicks on Less Than button
      And enter numeric values
      And click update button
      Then the results should be less than specified value

      @US10_AC7_1 @TRANS-1246
      Scenario: When the user selects the "Is Empty" method, only empty values should be displayed.
        And the user clicks on Chassis Number All button
        And the user clicks on dropdown menu
        And the user clicks on "is empty" dropdown
        And click update button
        Then only empty values should be displayed

