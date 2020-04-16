Feature: Shipping charge validation and Recommeded Tab validation

Background: 
   Given user is on Home Page

Scenario: User able to add four Address and update all added address on payment page
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then User Add "SILVER PARKING" Addons to minicart with "1" ticket in minicart
     When user click on Check out button of mini cart
     Then User able to see Enter Shipping Address Field
     And User click on proceed to payment Button
     When YWW User clicks on REGISTER NOW link 
     Then User redirects to registration page
     When User enter below valid details for registration
     And YWW User click on submit button for registration
     And User Without any Address and clcik on add address
     Then User able to see Shipping charge added
     Then Close browser
     
Scenario: User able to see tabMenu Container on booking page
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then Verify OtherTab should not come
    When User clicks on main Menu Experiences item and select "Drive"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify recommended tab should come
    And Verify all tabmenu should come
    Then Close browser
    
    
    
    
    