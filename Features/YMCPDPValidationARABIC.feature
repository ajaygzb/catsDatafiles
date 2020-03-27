@f1listing
Feature: Validate PDP Tickets overlay  
    Scenario: Verify select gift voucher and book product 
    When User validate "https://fe-dev4-ux-apps-cd.azurewebsites.net/ar/ymc/f1listingpage" PDP products
     Then Close browser