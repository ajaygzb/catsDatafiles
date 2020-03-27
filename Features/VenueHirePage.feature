Feature: Verify that User is able to land on Venue Detail page through Venue Track Card on Venue Hire Page



  Background: 
    Given user is on Home Page
      
    Scenario: Venue Hire Detail Page
        When user click on Venue in Header
        Then user click on card component on landing page
        Then user click on card component on listing page
        Then user land on detail Page
	    Then Close browser
	    