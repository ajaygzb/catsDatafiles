Feature: Booking_widget

  Background: User should be able to navigate home page
    Given user is on Home Page
  #YPS-6371
  Scenario: Verify the hotel booking widget
     When   User select checkin and checkout date
      And    user click on Get Packages
      When user click on Book Now
     Then User enters emailid
      And User enters password
     Then user click on submit button
     Then user Navigate to payment screen
     When user Make payment with credit card
     Then Close browser
