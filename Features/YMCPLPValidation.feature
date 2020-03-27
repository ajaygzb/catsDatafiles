@f1listing
Feature: Validate PLP Tickets overlay  
    Scenario: Verify select gift voucher and book product 
    When User validate "https://fe-dev4-ux-apps-cd.azurewebsites.net/en/ymc/f1listingpage" PLP products
     Then Close browser