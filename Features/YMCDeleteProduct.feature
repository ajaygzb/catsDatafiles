Feature: YMC Delete product and Recommendations from cart

  Background: 
    Given user is on Home Page
    
@test1   
   Scenario: Verify error message on Recommnedation tab when user add product with 2 Days
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then User Add "SILVER PARKING" Addons to minicart with "1" ticket in minicart
    Then User remove Addons in Minicart
    Then User remove Parent product from cart
    And User verify cart is empty
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then User Add "SILVER PARKING" Addons to minicart with "1" ticket in minicart
    Then User see error message when remove parent product
    Then Close browser