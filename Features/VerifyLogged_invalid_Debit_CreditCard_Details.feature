Feature: Verify when Loggedin user adds incorrect data in any of the Payfort Card details fields

Scenario: logged user Verify with fill invalid  card details 
            Given user is on Home Page   
            When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button
           When User clicks on Buy Ticket CTA
          When User clicks on Add to Cart button on general pass adult ticket
          When user click on Check out button on mini cart
          Then user enter wrong Debit Or Credit card details
          And select terms and condition checkbox
          And click on Pay Now button
          Then user verify error mgs for invalid input
          
          