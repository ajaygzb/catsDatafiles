Feature: YMC R2 formula one prouducts

  Background: 
    Given user is on Home Page
    
Scenario: Verify user is able to add GRAND PRIX BRUNCH and verify recommendations
#    When User clicks on MyProfile link
#    And User enters emailid
#    And User enters password
#    And user click on submit button
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "GRAND PRIX BRUNCH" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "1Day"
    Then Close browser 
   
    
 
Scenario: Verify user is able to add CHAMPIONS CLUB TRACKSIDE TERRACE and verify recommendations
    When User clicks on main Menu Formula1 item and select "Buy Tickets"
    And User select Non-Dated product "CHAMPIONS CLUB @TRACKSIDE TERRACE" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify recommended tab should come
    Then user is able to validate recommendations for "GOLDEN" for "2Day"
    Then Close browser  
