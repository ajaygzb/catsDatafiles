Feature: YMC R2 Abu Dhabi Hill Product and payment with Address

  Background: 
    Given user is on Home Page
    
Scenario: Verify user is able to add Abu Dhabi Family Package and verify recommendations
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "ABU DHABI HILL (FAMILY PACKAGE)" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "RED,GOLDEN,GOLDEN" for "3Day"
    When user click on Check out button of mini cart
    And verify user Navigate to payment page
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    Then Close browser 