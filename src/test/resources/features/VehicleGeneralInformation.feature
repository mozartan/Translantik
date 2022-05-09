@us007
Feature:US-007 Vehicle General Information

  @ac1 @TRANS-1208
  Scenario Outline: User can see the "General Information" page by clicking on any vehicle (row)
    When the store manager clicks <rowNumber> .row
    Then the General Information page should be displayed
    Examples:
      | rowNumber |
      | 1         |
      | 3         |
      | 5         |

  @ac2 @TRANS-1209
  Scenario: User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row
    Then the store manager clicks any three dot at the end of the row
    When the store manager clicks on the Eye "View" icon
    Then the General Information page should be displayed

  @ac3 @TRANS-1210
  Scenario Outline: User should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
    When the store manager clicks <rowNumber> .row
    Then the General Information page should be displayed
    Then Edit, Delete, and Add Event button should be displayed
    Examples:
      | rowNumber |
      | 7         |
      | 10        |
      | 12        |

  @ac4 @TRANS-1211
  Scenario Outline: Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
    Then check and store all information of <rowNumber> .row
    When the store manager clicks <rowNumber> .row
    Then verify the all information are all same for both pages
    Examples:
      | rowNumber |
      | 13        |
      | 15        |
      | 18        |

