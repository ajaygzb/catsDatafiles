Feature: Saadiyat Regression Static Pages
			 
Scenario:  Verify AboutUS scenario
        When user is on Home Page
        And User click on AboutUs link 
        Then veryfy AboutUs components is present
        Then Close browser
		
 Scenario: Verify user is able to view  all lists page for hotel
        When user is on Home Page
        And  Click on hotel and user is nvigate to tickect page 
        Then User are able to views all hotel pages
        Then Close browser
		
Scenario: Verify user is able to view legal page
        When user is on Home Page
        Then User click on Legal section on footer
        And  User verify Privacy Policy section present      
        Then Close browser

Scenario: Verify user is click Back to top
        When user is on Home Page
        Then User scroll down to footer and click on Back to top clickk
        And Verify that Header is getting displayed
        Then Close browser
		
Scenario:  Verify AboutUS scenario
        When user is on Home Page
        And user hover on Links HOTELS
        Then verify the all the hotels on dropdown
        And user hover on links Attraction
        Then verify the all the Atrractrion on dropdown
        Then Close browser
		
Scenario:  Verify Verify the Footer
        When user is on Home Page
        And Verify footer componets
        Then Veryfy Hotel Links on footer
        And  Verify Attractions Links on footer
        Then Verify About Links On Footer
        Then Close browser		