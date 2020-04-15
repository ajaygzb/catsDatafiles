Feature: Login with Partner and Minicart Validation

  Background: 
       Given user is on B2B Home Page

  Scenario: Login with Partner and inc dec and delete product
    Then B2B User click on SignIn CTA
    When B2B User enter below valid details for login
    And B2B User click on submit button for login
    When B2B User close the notification on Homepage
    Then B2B User verify dashboard
    When B2B User click on Book Ticket CTA
    Then B2B User empty minicart if product were there
    Then B2B User check minicart is empty
    Then B2B User select Non dated ticket type
    And B2B User add single park ticket  
    Then B2B User check minicart is not empty
    Then B2B user verify minicart details 
#    Then B2B user can edit product quantity
    Then B2B user can edit product quantity for nondated product  
    Then B2B user can delete product quantity 
    Then B2B User check minicart is empty
    Then Close browser 
