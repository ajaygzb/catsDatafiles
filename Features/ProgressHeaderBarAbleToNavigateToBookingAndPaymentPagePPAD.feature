Feature: Verify that anonymous user is able to navigate to Booking and Payment page by clicking on Progress Header bar
 @regression
Scenario: Verify checks out from the Mini cart then user lands on the payment page with cart section 
            Given user is on Home Page   
            When User clicks on Buy Ticket CTA
            Then User pick a date
            When User clicks on Add to Cart button on general pass adult ticket
            Then user click on Check out button on mini cart
            And User verify cart is not expanded state
            And  User is able to see payment page
            Then Close browser
            
    
    
    