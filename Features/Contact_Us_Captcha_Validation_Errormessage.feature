Feature: Contact us Page Captcha error validation 
Background: User should be able to navigate home page
			 Given user is on Home Page

        Scenario: Verify user is able to view contact us captcha error mgs
        And Click on contact us cta
        Then user fill  contact us form
     	Then user enter wrong captcha
        Then Click on contact us submit contact us submit cta
        And user able to see Captcha error message
        Then Close browser
        
        Scenario: Verify logged In user details are Pre-filled on Contact Use Page
       
        And  User clicks on MyProfile link
        And  user logs in
        And  Click on contact us cta
        Then user verify prefilled details in form
        Then user enter wrong captcha
        Then Click on contact us submit contact us submit cta
        And  user able to see Captcha error message
        Then Close browser

        
      
