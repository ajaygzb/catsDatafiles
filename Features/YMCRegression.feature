Feature: YMC regression Test cases

  Background: 
    Given user is on Home Page

  #  YPS-10254,YPS-10257,YPS-10262,YPS-10280,YPS-10371,YPS-10385
  #  YPS-10254,YPS-10257,YPS-10262,YPS-10280,YPS-10371,YPS-10385

# @test1 @sanityYMC @regressionYMC ---- merged this test with YMC Download Ticket
#  Scenario: Verify mode of payment,Order id is displayed,Order Total should be displayed,Order Sub Total should be displayed
#    When User clicks on MyProfile link
#    And User enters emailid
#    And User enters password
#    And user click on submit button
#    When User click on add to cart icon on home page
#    Then User empty minicart
#    Then verify user navigate to my Payment page and click on Buy Experiences button
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
#    When User select item in gift vouher list option
#    Then Verify chose your ticket Overlay should open
#    And User click on Terms and condition checkbox
#    And User click on Proceed to checkout Button on select Date Overlay
#    And verify user Navigate to payment page
#    When user enter payment information with credit card
#    And select terms and condition checkbox
#    And click on Confirm order button
#    Then user redirected to payment confirmation page
#    And user verify mode of payment
#    And user verify Order id is displayed
#    And user verify Order Total should be displayed
#    And user verify Order Sub Total should be displayed
#    Then Close browser

  # YPS-10356
#  @test2 @sanityYMC @regressionYMC --- merged this test case with YMC_ Buyticket
#  Scenario: Verify that it is mandatory to select the Terms & Conditions checkbox
#    When User click on add to cart icon on home page
#    Then verify user navigate to my Payment page and click on Buy Experiences button
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
#    When User select item in gift vouher list option
#    Then Verify chose your ticket Overlay should open
#    And User verify Proceed to checkout Button disabled
#    And User click on Terms and condition checkbox
#    And User click on Proceed to checkout Button on select Date Overlay
#    Then Close browser

#  @test3 -------------------- Bug in Blue env. YMC
#  Scenario: Verify that user will see recommendations Tab is user visits booking page after adding a product from PLP page
#    When User clicks on main Menu Experiences item and select "Drive"
#    And User select feature "YAS CAR TRACK DAY" and click on book now button.
#    And User select country of issue
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify recommended tab should come
#    Then Close browser

# @test1 --------------------- Bug while click on PDP Book now for Yas car Track day----------------
#  Scenario: Verify that user will see recommendations Tab is user visits booking page after adding a product from PDP page
#    When User clicks on main Menu Experiences item and select "Drive"
#    And User click on discover More button for Item that has recommneded items
#    And User select country of issue
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify recommended tab should come
#    Then Close browser

#   @test5 @prod ------------- feature is not available on any testing env. other than dev4
#  Scenario: Verify that user will see recommendations Tab for non dated is user visits booking page after adding a product from PLP page
#    When User clicks on MyProfile link
#    And User enters emailid
#    And User enters password
#    And user click on submit button
#    When User clicks on main Menu Formula1 item and select "WRX Listing"
#    And User select Non-Dated feature "Yas Central" and click on book now button.
#    Then User select quantity
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify recommended tab should come
#    Then Close browser

  # promocode ------------Bug in promocode--- merged this scenario with YMC_PromoCode.feature-----------
#   @test2 
#  Scenario: Verify that on the order confirmation screen, Promo Code details should be displayed in case user has applied any promo code
#    When User clicks on MyProfile link
#    And User enters emailid
#    And User enters password
#    And user click on submit button
#    When User click on add to cart icon on home page
#    Then User empty minicart
#    Then verify user navigate to my Payment page and click on Buy Experiences button
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
#    When User select item in gift vouher list option
#    Then Verify chose your ticket Overlay should open
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    Then user apply PromoCode in Mini cart
#    And user is able getting promo discount
#    When user click on Check out button of mini cart
#    And verify user Navigate to payment page
#    And Verify Promo Code details on Payment page
#    When user remove promocode from invoice summary page
#    Then verify copuon discount removed
#    And user navigate back to minicart
#    And verify coupon removed from minicart
#    Then Close browser

 @test3
  Scenario: Verify that on the order confirmation screen of a dated Product, following fields should be displayed Order ID,Product Name ,Product Quantity,Date valid
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drag"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    And user verify Order id is displayed
    And user verify Product Name is displayed
    And user verify Product Quantity is displayed
    And user verify Date valid is displayed
    Then Close browser

  @test4
  Scenario: Verify that a list of orders Placed by user is displayed when the user navigates to Order History section
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drag"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    And user verify Order History section
    When user clicks on an order in the list
    Then user is able to see order detail section on the screen
    Then Close browser

 @test5
  Scenario: Verify that on the order confirmation screen, View Order will be there which will take user to purchase history page.
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    When User clicks on main Menu Experiences item and select "Drag"
    When User navigate to PLP throught experience option for selecting date to Book product
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    When user clicks on view order on confirmation page
    Then user will navigate to purchase history page
    Then Close browser

  @test6
  Scenario: Verify Dated Product is added in mini cart of booking page and user click on Proceed To Checkout CTA in Mini cart,User will be redirected to Payment Page with Product Summary consisting same
    When User clicks on main Menu Experiences item and select "Drag"
    And User click on discover More button
    And User select country of issue
    And User click on Terms and condition checkbox
    And User click on Add to cart Button on select Date Overlay
    And Verify user Navigate to Booking Page and Minicart is present
    And user verifies the product amount listed on cart
    When user click on Check out button of mini cart
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    And User click on proceed to payment Button
    Then verify user navigate to login page
    And User enters emailid
    And User enters password
    And user click on submit button
    And verify user Navigate to payment page
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    Then Close browser

  @test7
  Scenario: Verify that price will be updated if user selects cross sell product (with Video).
    When User clicks on MyProfile link
    And User enters emailid
    And User enters password
    And user click on submit button
    When User click on add to cart icon on home page
    Then User empty minicart
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    When User select cross sell product from list
    Then Verify chose your ticket Overlay should open
    Then User should select available date and time Slot
    And User select country of issue
    And User click on Terms and condition checkbox
    Then verify price will update if user select cross sell product with video
    Then Close browser

# @test12
#  Scenario: Verify that on the order confirmation screen, Discount details should be displayed against products if product is eligible for any discount.
#    When User clicks on main Menu Experiences item and select "Drive"
#    And User select feature "YAS CAR TRACK DAY" and click on book now button.
#    And User select country of issue
#    Then verify Discount details should be displayed against products if product is eligible for any discount
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify recommended tab should come
#    And user verifies the product amount listed on cart
#    Then verify Discount details should be displayed against products if product is eligible for any discount
#    Then Close browser

# @test8 ----------- Covered with "Then User empty minicart" in other scenarios
#  Scenario: Verify that user can delete all the items in product summary section & sees a There is no ticket in Cart & CTA redirecting to Booking Page.
#    When User clicks on main Menu Experiences item and select "Drive"
#    When User navigate to PLP throught experience option for selecting date to Book product
#    And User select country of issue
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And user verifies the product amount listed on cart
#    When user click on Check out button of mini cart
#    Then Verfy User Navigate to Mypayment page and invoice Summary is present
#    And User click on proceed to payment Button
#    Then verify user navigate to login page
#    And User enters emailid
#    And User enters password
#    And user click on submit button
#    And verify user Navigate to payment page
#    Then user click on booking page link in summary page
#    And Verify user Navigate to Booking Page and Minicart is present
#    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
#    When User select item in gift vouher list option
#    Then Verify chose your ticket Overlay should open
#    And User click on Terms and condition checkbox
#    And User click on Proceed to checkout Button on select Date Overlay
#    And verify user Navigate to payment page
#    When User click on add to cart icon on home page
#    Then User empty minicart
#    And User should see the empty state of the mini cart
#    Then verify user navigate to my Payment page and click on Buy Experiences button
#    Then User navigate back to booking page Mini cart should not have the deleted product in minicart.
#    Then Close browser

   @test9
  Scenario: Verify select gift voucher and book product with new user
    When User click on add to cart icon on home page
    Then verify user navigate to my Payment page and click on Buy Experiences button
    And Verify user Navigate to Booking Page and Minicart is present
    And Verify and select "GIFT VOUCHER" Voucher tab is present on Booking page
    When User select item in gift vouher list option
    Then Verify chose your ticket Overlay should open
    And User click on Terms and condition checkbox
    And User click on Proceed to checkout Button on select Date Overlay
    Then Verfy User Navigate to Mypayment page and invoice Summary is present
    And User click on proceed to payment Button
    Then verify user navigate to login page
    Then user click on Sign up option on registration page
    Then User redirects to registration page
    When User enter below valid details for registration
    And YWW User click on submit button for registration
    And verify user Navigate to payment page
    When user enter payment information with credit card
    And select terms and condition checkbox
    And click on Confirm order button
    Then user redirected to payment confirmation page
    Then Close browser

#   @test10
# ------------merged with Verify that user can delete all the items in product summary section--------
#  Scenario: Verify that user can delete a product from  Product summary section & navigate back to booking page. Mini cart should not have the deleted product in minicart.
#    When User clicks on main Menu Experiences item and select "Drive"
#    When User navigate to PLP throught experience option for selecting date to Book product
#    And User select country of issue
#    And User click on Terms and condition checkbox
#    And User click on Add to cart Button on select Date Overlay
#    And Verify user Navigate to Booking Page and Minicart is present
#    And user verifies the product amount listed on cart
#    When user click on Check out button of mini cart
#    Then Verfy User Navigate to Mypayment page and invoice Summary is present
#    And User click on proceed to payment Button
#    Then verify user navigate to login page
#    And User enters emailid
#    And User enters password
#    And user click on submit button
#    And verify user Navigate to payment page
#    Then User empty minicart
#    And User should see the empty state of the mini cart
#    Then verify user navigate to my Payment page and click on Buy Experiences button
#    Then User navigate back to booking page Mini cart should not have the deleted product in minicart.
#    Then Close browser
