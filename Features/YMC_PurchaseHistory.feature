Feature: YMC regression Test cases

  Background: 
    Given user is on Home Page
 
  Scenario: Verify that on the order confirmation screen of a dated Product, following fields should be displayed Order ID
            ,Product Name ,Product Quantity,Date valid also verify order history page with details
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drive"
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
    And user verify Order id is displayed
    And user verify Product Name is displayed
    And user verify Product Quantity is displayed
    And user verify Date valid is displayed
    And user verify Order History section
    When user clicks on an order in the list
    Then user is able to see order detail section on the screen
    Then Close browser



  Scenario: Verify that on the order confirmation screen, View Order will be there which will take user to purchase history page.
    When User clicks on MyProfile link 
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drive"
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
    When user clicks on view order on confirmation page
    Then user will navigate to purchase history page
    Then Close browser

 