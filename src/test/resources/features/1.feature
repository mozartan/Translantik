@TRANS-1278
Feature: Default
	@TRANS-1273
	Scenario: US-005 AC1 User can access the "General Information" page (by clicking on any vehicle/row under Fleet-Vehicle module)
		When Store manager click on any vehicle
		And Store manager will see "General Information" page	

	@TRANS-1274
	Scenario: US-005 AC2 Store manager can click the "Add Event" button
		When Store manager click on any vehicle
		Then Store manager can see addEvent button
		And Store manager can click on addEvent button	

	@TRANS-1275
	Scenario: US-005 AC3 Store Managers can see AddEvent page
		When Store manager click on any vehicle
		When Store manager can click on addEvent button
		Then "Add Event" Page opens	


	@TRANS-1276
	Scenario: US-005 AC4 Compulsory Fields must be marked
		When Store manager click on any vehicle
		When Store manager can click on addEvent button
		Then Compulsory Fields must be shown
		      | Title                  |
		      | Owner                  |
		      | Organizer display name |
		      | Organizer email        |
		      | Start                  |
		      | End                    |	


	@TRANS-1277
	Scenario Outline: US-005 AC5 If any compulsory field is not filled, "This value should not be blank." message should be displayed
		When Store manager click on any vehicle
		And Store manager can click on addEvent button
		Then Store manager should not save event without filling out compulsory "<Title>" , "<Organizer display name>", "<Organizer email>"
		Then "Lütfen bu alanı doldurun." message should be displayed
		    Examples:
		      | Title     | Organizer display name | Organizer email  |
		      |           | Ali                    | dd@mail.com      |
		      | ProMain   |                        | ale1457@mail.com |
		      | Maintaned | Veli                   |                  |