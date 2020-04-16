Feature: logged user my profile user AddAddress and Delete also update 

Background: 
   Given user is on Home Page
Scenario: User add Address and verify filled addess form
          When YWW User clicks on REGISTER NOW link
         Then User redirects to registration page
         When User enter below valid details for registration
         And YWW User click on submit button for registration
        Then User Hover and Click on my profile
        And User Without any Address and clcik on add address
        And User Delete Address
        Then Close browser
       
Scenario: User able to added four Address
    When YWW User clicks on REGISTER NOW link
    Then User redirects to registration page
    When User enter below valid details for registration
    And YWW User click on submit button for registration
    Then User Hover and Click on my profile
    Then User fill shipping address form
    And User Delete Address
    Then Close browser
Scenario: User able to add four Address and update all added address on payment page
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then User Add "SILVER PARKING" Addons to minicart with "1" ticket in minicart
     When user click on Check out button of mini cart
     And User click on proceed to payment Button
     When YWW User clicks on REGISTER NOW link
     Then User redirects to registration page
     When User enter below valid details for registration
     And YWW User click on submit button for registration 
     Then User fill shipping address form
     When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
     Then Close browser
    



    
   