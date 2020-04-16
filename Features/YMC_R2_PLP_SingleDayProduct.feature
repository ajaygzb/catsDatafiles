Feature: YMC R2 formula one prouducts with PLP

  Background: 
    Given user is on Home Page
    
    
 Scenario: Verify user is able to add PADDOCK CLUB 1 DAY with PLP and verify recommendations
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "PADDOCK CLUB - 1 DAY" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "1Day"
    Then Close browser  
