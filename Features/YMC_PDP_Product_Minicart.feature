Feature: add product from Product Detail Page and verify in minicart

  Scenario: Verify that user add tickets from PDP and verify numbers in minicart
    Given user is on Home Page
    When User clicks on main Menu Experiences item and select "Drive"
    And User click on discover More button
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    When User clicks on main Menu Experiences item and select "Drag"
    And User click on discover More button
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    When User clicks on main Menu Experiences item and select "Drift" 
	And User click on discover More button 
	And User click on Terms and condition checkbox 
	And User click on Add to cart Button on select Date Overlay 
	When User clicks on main Menu Experiences item and select "Ride" 
	And User click on discover More button 
	And User click on Terms and condition checkbox 
	And User click on Add to cart Button on select Date Overlay 
	When User clicks on main Menu Experiences item and select "Tour" 
	And User click on bookNow button 
	Then User select quantity 
	And User click on Terms and condition checkbox 
	And User click on Add to cart Button on select Date Overlay 
	And Verify user Navigate to Booking Page and Minicart is present 
	Then user verify "5" products in minicart
	Then Close browser