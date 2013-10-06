@Authenticate
Feature: Authentication

@Regression @Sniff
Scenario: To verify that login option shown when I am not logged in

Given I'm not logged in
When I view the home page of the BBC News
Then I should be presented with an option to sign in

@Regression
Scenario: To verify that sign out option is available for logged in user

Given I'm logged in
When I view the home page of the BBC News
Then I should be presented with an option to sign out