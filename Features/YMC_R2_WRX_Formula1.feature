Feature: YMC R2 WRX and Formula Product

  Background: 
    Given user is on Home Page
    

 Scenario: Verify user is able to add WRX Product 1 with PLP and verify recommendations
    And User select Non-Dated product "North Club" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    Then Close browser  
 
 
 Scenario: Verify user is able to add WRX Product 1 with PLP and formula 3 Day and verify recommendations
    And User select Non-Dated product "North Club" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "PADDOCK CLUB - 3 DAYS" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "3Day"
    Then user is able to validate recommendations for WRX Product
    Then Close browser    