Feature: YMC R2 Abu Dhabi Hill Product

  Background: 
    Given user is on Home Page
    
   
Scenario: Verify user is able to add Abu Dhabi 2 Day with PDP and verify recommendations
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on explore CTA button
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "RED,GOLDEN,GOLDEN" for "2Day"
    Then Close browser 
    
 
Scenario: Verify user is able to add Abu Dhabi 3 Day and verify recommendations
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 3 DAYS" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
   Then user is able to validate recommendations for "RED,GOLDEN,GOLDEN" for "3Day"
    Then Close browser  
 

 
 
 
 
   
  
    