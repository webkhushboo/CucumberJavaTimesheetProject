Feature: Test Timesheet smoke scenario

   Scenario: Enter timesheet daily
      Given Open chrome and start application
      When I enter valid "INR000350" and valid "Allegis@2112"
      Then user should be able to login successfully
      Then Click on Manage Time
      Then Click on previous week
      Then Click on last date of previous week
      Then Click on copy time
      Then Click on submit button
      And Close the browser