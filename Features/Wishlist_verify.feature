Feature: Wishlist_and social share verify
Background: User should be able to navigate home page
			 Given user is on Home Page
			 
Scenario:  Verify Wishlist item non logged user
          Given User, click on wishlist icon
          And   User verify wishlist is empty
		  Then User click on hotels navigation link
		  And User click on hotels wishlist icon
		  #And User verify wishlist on wishlist page
		  Then Close browser
Scenario:  Verify Wishlist Logged user
           When User clicks on MyProfile link
           Then User enters emailid
           And User enters password
           Then user click on submit button 
          Given User, click on wishlist icon
		  Then User click on hotels navigation link
		  And User click on hotels wishlist icon
		  And User verify wishlist on wishlist page
		  Then User Delete All item
		  And User verify wishlist is empty 
	      Then Close browser

Scenario: YPS-6871_Verify user is able to share the Yas Island page across the social sites
 Then User click on hotels navigation link
 Then user click on and share social site
 Then Close browser
