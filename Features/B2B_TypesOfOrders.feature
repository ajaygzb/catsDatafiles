Feature: Verify that all types of Order coming for partner Operator Agent
       

  Background: 
       Given user is on B2B Home Page

  Scenario: Login with Partner and verify Order Types
    Then B2B User click on SignIn CTA
    When B2B User enter below valid details for login
    And B2B User click on submit button for login
    When B2B User close the notification on Homepage
    Then B2B User verify dashboard
    When B2B user clicks on MyOrders button present under Profile icon
    Then B2B user check different type of orders
    Then Close browser
    
  Scenario: Login with Operator and verify Order Types
    Then B2B User click on SignIn CTA
    When B2B User enter below valid details for login with Operator 
    And B2B User click on submit button for login
    When B2B User close the notification on Homepage
    Then B2B User verify dashboard
    When B2B user clicks on MyOrders button present under Profile icon
    Then B2B user check different type of orders
    Then Close browser
    
  Scenario: Login with Agent and verify Order Types
    Then B2B User click on SignIn CTA
    When B2B User enter below valid details for login with Agent 
    And B2B User click on submit button for login
    When B2B User close the notification on Homepage
    Then B2B User verify dashboard
    When B2B user clicks on MyOrders button present under Profile icon
    Then B2B user check different type of orders
    Then Close browser
    
    
    
    