Feature: YMC R2 formula one prouducts with PLP

  Background: 
    Given user is on Home Page
    

 Scenario: Verify user is able to add WRX Product 3 with PLP and verify recommendations
    And User select Non-Dated product "WRX General Admission" and click on book now button.
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    Then Close browser  
 
 
 Scenario: Verify user is able to add WRX Product 2 with PLP and verify recommendations
    And User select Non-Dated product "WRX Hospitality" and click on explore CTA button
    Then User select quantity
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    Then user is able to validate recommendations for WRX Product
    Then user is able to see all WRX product on world rallycross tab
    Then Close browser    