Feature: Book As Gift for Non Dated Ticket

  Scenario: Verify non dated Ticket with book as Gift
  Given user is on Home Page
    When User clicks on main Menu Experiences item and select "Drive"
    And User click on discover More button and then Book As Gift
    And user add tickets if not added
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Close browser
    
    