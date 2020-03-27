Feature: Validate Cart Data

  Scenario Outline: user add two types of General Admission Ticket and Compare MiniCart and Cart Summary Data
    Given user is on Home Page
    When User clicks on Buy Ticket CTA
    Then User empty minicart if product were there
    And user add "2" adult and "1" junior
    Then User select the <type1> of General Admission ticket
    Then user expand minicart if not expanded
    And user add "2" adult and "3" junior
    Then User select the <type2> of General Admission ticket
    Then Store current values of "miniCart" in site
    When user click on Check out button on mini cart
    Then user expand cartSummary if not expanded
    Then Store current values of "cartSummary" in site
    Then Compare MiniCart and CartSummary
    And user is able to enter details of guest form
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Pay Now button
    Then user redirected to payment confirmation page
    Then Store current values of "ticketConfirmation" in site
  	Then Compare MiniCart and ticketConfirmationSummary
    Then user click on Download ticket button
    #Then Close browser

    Examples: 
      | day | day1 | type1             | type2             | MiniCartOneDay    | MiniCartTwoDay     |
      |  15 |   10 | 2 Day Any 2 Parks | 1 Day Any 2 Parks | 1 Day Any 2 Parks | 2 Days Any 2 Parks |
