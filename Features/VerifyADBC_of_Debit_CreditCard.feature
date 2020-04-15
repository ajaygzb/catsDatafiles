Feature: Verify payment method when user starts typing ADCB card number and enter four digits get a notified that he she is using a ADCB card

Scenario: non logged VerifyType_of_Debit_CreditCard
          Given user is on Home Page   
          When User clicks on Buy Ticket CTA
          When User clicks on Add to Cart button on general pass adult ticket
         When user click on Check out button on mini cart
		 Then user enter Debit or Credit card num and verify
		 Then Close browser
		  

Scenario: logged VerifyType_of_Debit_CreditCard
			Given user is on Home Page
           When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button
           When User clicks on Buy Ticket CTA
          When User clicks on Add to Cart button on general pass adult ticket
         When user click on Check out button on mini cart
		 Then user enter Debit or Credit card num and verify
          Then Close browser 
	
