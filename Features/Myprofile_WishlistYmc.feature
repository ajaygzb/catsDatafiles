Feature: user is able to see wishlist on My Profile Page under Wishlist TAB
 
Background: User should be able to navigate home page
     Given user is on Home Page
     
  #Scenario: user is see wishlist on My Profile Page under Wishlist and delete 
           #When User clicks on MyProfile link
           #Then User enters emailid
           #And User enters password
           #Then user click on submit button
           #When User clicks on main Menu Experiences item and select "Drive"
           #Then User click on discoverMore and add wishlist
           #Then User Hover and Click on my profile
           #Then User click on Wishlist Tab And Verify 
           #And  User delete the wishlist 
           #Then User verify empty wishlist
           #Then Close browser
#Scenario: User is able to land on Venue Track hire page component tile
           #When User clicks on Venue and TrackHire in homepage
           #Then User clicks on Venue
           #And  User verify the venune tiles
           #Then Close browser
 
 Scenario: user is redirected to Booking Page as per the product selected on wishlist items 
           When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button
           When User clicks on main Menu Experiences item and select "Drive"
           Then User click on discoverMore and add wishlist
           Then User Hover and Click on my profile
           Then User click on Wishlist Tab And Verify
           And User click on book now button
           Then User should select available date and time Slot
           And User select country of issue
           And User click on Terms and condition checkbox
           And User click on Proceed to checkout Button on select Date Overlay
           When user enter payment information with credit card
           When select terms and condition checkbox
           And click on Pay Now button
           Then user redirected to payment confirmation page
           Then Close browser
 



           
