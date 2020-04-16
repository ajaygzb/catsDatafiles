Feature: YMC R2 Formula and Experience Product

  Background: 
    Given user is on Home Page
    
   
Scenario: Verify user is able to add Abu Dhabi 2 Day with PLP and Exprience Product and verify recommendations
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "RED,GOLDEN,GOLDEN" for "2Day"
    When User clicks on main Menu Experiences item and select "Drive"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "RED,GOLDEN,GOLDEN" for "2Day"
    And Verify all tabmenu should come
    Then Close browser 
     
 

 
 
 
 
   
  
    