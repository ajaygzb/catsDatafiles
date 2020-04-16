Feature: YMC R2 WRX and Expiernce with PDP

  Background: 
    Given user is on Home Page
    
   
Scenario: Verify user is able to add WRX 2 Day with PDP and Exprience Product and verify recommendations
    And User select Non-Dated product "WRX Hospitality" and click on explore CTA button
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    When User clicks on main Menu Experiences item and select "Drag"
    And User click on discover More button
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    Then user is able to validate recommendations for WRX Product
    And Verify all tabmenu should come
    Then Close browser 
     
 

 
 
 
 
   
  
    