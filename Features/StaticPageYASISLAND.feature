Feature: Validation of Listing Page and Offer Page and tripadvisor page and event search
 
Background: User should be able to navigate home page
     Given user is on Home Page
     
  Scenario: user is able to open listing page
        When User clicks on city link
        When User verify tile heading
        When User verify tile subtext
        When User clicks on discover link
        When User verify hero panel
        When User verify wishlist icon
        Then Close browser
 
 Scenario: user lands on offers and promotion page
        When User clicks on Offers link in header
        Then User should land on Offers page
       Then User is able to see offer name
      Then User is able to see offer venue
     Then User is able to see offer description
     Then Close browser
     
  Scenario: user is able to open tripadvisor details and reviews
        When User clicks on YAS Vibes link
        When User clicks on any hotel
        When User clicks on tripad icon
        When Verify Travel rating 
        Then Close browser      
		
Scenario: verify user is able to go to listing page and check event search
         When User clicks on Event  link
         When User clicks on search button
        When User fills in search details
        Then It should be able to select venue and date
        When User clicks on search button
        When User changes dates from calendar
        Then It should be able to select venue and calendar date range
        When User clicks on search button
        Then Close browser
		 		