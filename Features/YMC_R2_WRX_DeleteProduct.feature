Feature: YMC Delete product and Recommendations from cart

  Background: 
    Given user is on Home Page
    
  
   Scenario: User add WRX product and then delete recommendation first and then parent product
    And User select Non-Dated product "North Club" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for WRX Product
    Then User Add "WRX Parking Silver 1" Addons to minicart with "1" ticket in minicart
    Then User remove Addons in Minicart
    Then User remove Parent product from cart
    And User verify cart is empty
    Then Close browser
    
   Scenario: Verify error message on Recommnedation tab when user add product WRX
    And User select Non-Dated product "North Club" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for WRX Product
    Then User Add "WRX Parking Silver 1" Addons to minicart with "1" ticket in minicart
    Then User see error message when remove parent product
    Then Close browser