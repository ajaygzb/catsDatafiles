Feature: user verify header and footer non logged user 

Background: User able to see homepage
   Given user is on Home Page

Scenario: header  verify  YMC 
          When User able to see header part
          Then Close browser
          
 Scenario: footer  verify  YMC 
          When User able to see footer part
          Then Close browser
          