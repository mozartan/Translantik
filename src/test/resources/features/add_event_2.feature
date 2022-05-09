@ADDEVENT-2
Feature: US-006 Add Event-2-As a store manager, user should be able to add an event

  Background:
    Given the user is on the add event pop up
  @TRANS-1224 @AC1
  Scenario: AC-1 User can mark the event with any color at the "Add Event" pop up
    Then the user should be able to click on any color
  @TRANS-1225 @AC2
  Scenario: AC-2 User can mark it as an "All-day event"
    When the user click on All-day event
    Then All-day event checkbox should be able to be selected
  @TRANS-1226 @AC3
  Scenario: AC-3 User can repeat the action by specifying occurrence periods and ending time
    When the user click on Repeat button
    Then Repeat checkbox should be able to be selected
  @TRANS-1227 @AC3
  Scenario: AC-3 Repeat options should include the below options
    When the user click on Repeat button
    Then options should be able to same with below
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |
  @TRANS-1228 @AC3
  Scenario: AC-3 Repeat options should be able to be selectable
    When the user click on Repeat button
    Then options which are below should be able to selectable
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |
  @TRANS-1229 @AC3
  Scenario: AC-3 Ending options' text should be to as below
    Given the user click on Repeat button
    Then Ending options' text should be to as below
      | Never |
      | After |
      | By    |
  @TRANS-1230 @AC3
  Scenario: AC-3 User Ending options should be as below and clickable
    Given the user click on Repeat button
    Then following options should be able to clickable
      | Never  |
      | After  |
      | By     |
  @TRANS-1231 @AC4
  Scenario: AC-4 User should be able to see all events on the General Information page
    When the user enter compulsary fields and save
    Then the user should see the title of the event at the GeneralInformation page Activity part