Feature: add product from Product Listing Page and verify in minicart


  Scenario: Verify that user add tikcets and verify numbers in minicart
    Given user is on Home Page
    When User clicks on main Menu Experiences item and select "Drive"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    When User clicks on main Menu Experiences item and select "Drag"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    #When User clicks on main Menu Experiences item and select "Drift"
    #When User navigate to PLP throught experience option for selecting date to Book product
#    And User click on Terms and condition checkbox
#    And User click on Proceed to checkout Button on select Date Overlay
    When User clicks on main Menu Experiences item and select "Ride"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User click on Terms and condition checkbox
    And User click on Proceed to checkout Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user verify "3" products in minicart
    Then Close browser