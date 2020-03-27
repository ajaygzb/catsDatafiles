Feature: Booking Via Cart and move to PDP by clicking on Name of Product

    Scenario: Verify user book Via Cart and move to PDP by clicking on Name of Product
    Given user is on Home Page
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify and select "DRIVE" Voucher tab is present on Booking page
    Then user click on Product Name and verify it move to PDP
    Then Close browser