Feature: YMC regression Test cases

  Background: 
    Given user is on Home Page

@test1
Scenario: Verify error message on Recommnedation tab when user add product with 1 Day
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "PADDOCK CLUB - 1 DAY" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    And User verify max limit reached for "1 day" product
    Then User remove Addons in Minicart
    Then Close browser
    
@test2   
   Scenario: Verify error message on Recommnedation tab when user add product with 2 Days
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then User Add "SILVER PARKING" Addons to minicart with "2" ticket in minicart
    When User Add More "RED PARKING" Addon error message appears for Max Limit Reached
    Then User remove Addons in Minicart
    Then User Add "RED PARKING" Addons to minicart with "2" ticket in minicart
    When User Add More "SILVER PARKING" Addon error message appears for Max Limit Reached
    Then Close browser
   
   
   #@test3   
   #Scenario: Verify error message on Recommnedation tab when user add product with 3 Days or Family Package
    #When User clicks on main Menu Formula1 item and select "Buy Tickets"
    #And User select Non-Dated product "ABU DHABI HILL - 2 DAYS" and click on book now button.
    #And User click on Terms and condition checkbox
    #And User click on Add to cart Button on select Date Overlay
    #And Verify user Navigate to Booking Page and Minicart is present
    #And Verify recommended tab should come
    #And User verify max limit reached for "2 day" product
    #Then Close browser