Feature: Annual Pass with login at payment page and paypal payment

  @regression1
  Scenario: Verify that user is able to add tickets in cart and checkout with guest details
    Given user is on Home Page
    When User clicks on Buy Ticket CTA
    When User should see the empty state of the mini cart
    When User clicks on Annual Passes
    Then user add "1" Annual Passes to cart
    When user click on Check out button on mini cart
    And user verifies the product amount listed on cart page
    Then user click on login option
    Then user logs in
    Then user fill information for another pass holder
    And select terms and condition checkbox for paypal
    When user enter payment information with paypal
    Then user redirected to payment confirmation page
    Then Close browser

  @regression2
  Scenario: To Verify that logged in user is able to add tickets in cart and checkout
    Given user is on Home Page
    When User clicks on MyProfile link
    Then user logs in
    When User clicks on Buy Ticket CTA
    Then User empty minicart if product were there
    When User clicks on Annual Passes
    Then user add "2" Annual Passes to cart
    When user click on Check out button on mini cart
    And user verifies the product amount listed on cart page
    Then user fill information for another pass holder
    And select terms and condition checkbox for paypal
    When user enter payment information with paypal
    Then user redirected to payment confirmation page
    Then Close browser

  @regression3
  Scenario: To Verify that logged in user is able to add tickets in cart and checkout using credit card
    Given user is on Home Page
    When User clicks on MyProfile link
    Then user logs in
    When User clicks on Buy Ticket CTA
    Then User empty minicart if product were there
    When User clicks on Annual Passes
    Then user add "1" Annual Passes to cart
    When user click on Check out button on mini cart
    And user verifies the product amount listed on cart page
    Then user fill information for another pass holder
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Pay Now button
    Then user redirected to payment confirmation page
    Then Close browser
