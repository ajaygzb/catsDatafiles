Feature: User Profile Login and Logout


  Background: 
    Given user is on Home Page
    
    Scenario: User Login and then Logout
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    Then user verify on My Profile button present under Profile icon is present
    When user logs out
    Then verify user logout successfully       
	Then Close browser
	
	 Scenario: Verify that as a already registered Yas Marina Circuit user should not be able to register on the site again
	 When YWW User clicks on REGISTER NOW link
    Then User redirects to registration page
    When User enter below valid details for registration
    And YWW User click on submit button for registration
    When user logs out
    When YWW User clicks on REGISTER NOW link
    Then User redirects to registration page
    When User enter already registered mail for registration
    And YWW User click on submit button for registration
    Then user should get error msg for wrong details
    Then Close browser