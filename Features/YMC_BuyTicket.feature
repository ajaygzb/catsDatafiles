Feature: Validate that user is redirected to Payment
          Cart Page when user clicks on  Proceed to checkout CTA

  
    Scenario: Verify select gift voucher and book product 
    Given user is on Home Page
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
    When User select item in gift vouher list option
    Then Verify chose your ticket Overlay should open
    And User verify Proceed to checkout Button disabled
    And User click on Terms and condition checkbox
    And User click on Proceed to checkout Button on select Date Overlay
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
     Then Close browser