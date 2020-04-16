Feature: YMC R2 WRX and Formula Product and Exprience with PLP to Payment

  Background: 
    Given user is on Home Page
    
 
 Scenario: Verify user is able to add WRX Product 3 with PLP and formula 3 Day and Exprience
    And User select Non-Dated product "WRX General Admission" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL - 3 DAYS" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "3Day"
    Then user is able to validate recommendations for WRX Product
#    Then user is able to validate recommendations for WRX Product
    When User clicks on main Menu Experiences item and select "Drive"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "3Day"
    Then user is able to validate recommendations for WRX Product
    And Verify all tabmenu should come
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    And User click on proceed to payment Button
    Then verify user navigate to login page
    And User enters emailid
    And User enters password
    And user click on submit button
    And verify user Navigate to payment page
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    Then Close browser    