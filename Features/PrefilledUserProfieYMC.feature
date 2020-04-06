Feature: logged user is able to visit YasIn School detail 
         and check profile information should appear prefilled

Background: 
   Given user is on Home Page

 #Scenario: Verify School detail Enquire form prefilled
    #When YWW User clicks on REGISTER NOW link
    #Then User redirects to registration page
    #When User enter below valid details for registration
    #And YWW User click on submit button for registration
    #When user logs out
    #Then user logs in again
    #Then user click on YasInSchool
    #Then user click on enquire now 
    #Then user validate information in enquire form
    #Then Close browser
#	
#Scenario: Verify school Detail Register form prefilled
    #When YWW User clicks on REGISTER NOW link
    #Then User redirects to registration page
    #When User enter below valid details for registration
    #And YWW User click on submit button for registration
    #When user logs out
    #Then user logs in again
    #Then user click on YasInSchool
    #Then user click on enquire now for register
    #Then user validate information in registaion form
    #Then Close browser 
#	
 #Scenario: Verify logged user school media registration form prefilled
    #When YWW User clicks on REGISTER NOW link
    #Then User redirects to registration page
    #When User enter below valid details for registration
    #And YWW User click on submit button for registration
    #When user logs out
    #Then user logs in again
    #Then user click on media center
    #Then user verify on media center details
    #Then user click on  register your interest 
    #Then user validate media prefiiled registaion form
    #Then Close browser
 #merge
 
 
 Scenario: User is able to verify HeathAndFitness programm  form
           When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button
           Then User click on HandF link
           Then User click on Register now
           And User verify the prefill form
           Then user enter the requried data 
           Then user enter wrong captcha
           Then Click on contact us submit contact us submit cta
           And  user able to see Captcha error message
           Then Close browser
 @test1          
 Scenario: User is able to submit Quote page form through Creative Service page
           When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button
           When User clicks on Venue and TrackHire in homepage
           Then User clicks on Venue
           And user click on featue tiles and click on quote
           Then user fill quote form
           Then user enter wrong captcha
           Then Click on contact us submit contact us submit cta
           And  user able to see Captcha error message
           Then Close browser
 
    