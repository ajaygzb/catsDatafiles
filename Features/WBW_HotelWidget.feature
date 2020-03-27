Feature: Verify Hotel Widget and Ticket and Annual Pass 

Background: User should be able to navigate home page
			 Given user is on Home Page



#YPS-3322,YPS-3324			 
Scenario: Verify Hotel Widget/ Ticket and Annual Pass 
        
         When User click on Park tickets
         Then User verify Genral Admission tab selected 
         Then user navigate on Home Page         
         Then User click on Annual Pass tab
         Then User verify Annual Pass tab selected
         Then Close browser