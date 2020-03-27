Feature: CheckStickyHeader and MegaNav and footer verify
 

  Background: User should be able to navigate home page
     Given user is on Home Page

  Scenario: logo On sticky header
        Then header should be sticky and logo should be present
        Then book CTA should be present on sticky header
         Then primary links should be present
       	Then Close browser
       
 Scenario: Mega Nav link under Things to do link in header opens up also Places to stay link in header
        When User hovers on things to do link in header
        Then mega nav one should open up
        When User hovers on Places to stay link in header
        Then mega nav two should open up
        Then Close browser
        
   Scenario: footer for guest user
        When User verify footer for guest user
        Then Close browser
		
   Scenario: footer for logged in user
         When User clicks on MyProfile link
         Then User enters emailid
         And User enters password
         Then user click on submit button  
        When User verify footer for loggedin user
         Then Close browser      