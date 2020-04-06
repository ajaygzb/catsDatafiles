Feature: YMC regression Test cases

  Background: 
    Given user is on Home Page

  # to be executed on non-headless mode  
   
  Scenario: Verify that on the order confirmation screen, Download Ticket will be there which will download the e-ticket
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drag"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    And user verify mode of payment
    And user verify Order id is displayed
    And user verify Order Total should be displayed
    And user verify Order Sub Total should be displayed
    Then user click on Download ticket button
    Then user verify confirmation email contains order id
    Then Close browser
    
 
  