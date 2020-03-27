Feature: Invalid Payment Credential Verififcation


  Scenario: Verify that user get error message for invalid credentials of card for payment
    Given user is on Home Page
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
    When User select item in gift vouher list option
    Then Verify chose your ticket Overlay should open
     And User click on Terms and condition checkbox
    And User click on Proceed to checkout Button on select Date Overlay
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    And User click on proceed to payment Button
    Then verify user navigate to login page
    And User enters emailid
    And User enters password
    And user click on submit button
    And verify user Navigate to payment page
    When user enter invalid credit card details
    And select terms and condition checkbox
    And click on Confirm order button
    Then user get the error message for valid information
    Then Close browser
