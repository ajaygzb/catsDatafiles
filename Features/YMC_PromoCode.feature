Feature: mini cart PromoCode Verification

Scenario: Verify select GIFT VOUCHER and verify promocode 
    Given user is on Home Page
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
   And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
    When User select item in gift vouher list option
    Then Verify chose your ticket Overlay should open
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay 
    Then user verify promocode in minicart 
    When user click on Check out button of mini cart
    And verify user Navigate to payment page
    And Verify Promo Code details on Payment page
    When user remove promocode from invoice summary page
    Then verify copuon discount removed
    And user navigate back to minicart
    And verify coupon removed from minicart
    Then Close browser


Scenario: Verify select product and verify invalid promocode with message 
    Given user is on Home Page
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
    When User select item in gift vouher list option
    Then Verify chose your ticket Overlay should open
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay 
    Then user verify invalid promocode message in minicart
    When user click on Check out button of mini cart 
    Then Close browser