@HomePage
Feature: Home Page Features Section

@Regression @Sniff
Scenario: To Verify each feature in home page has thumbnail associated with that.
Clicking on a story takes the user to the story page.

When I view the home page of the BBC News
Then there should be a features section
And it should contain 8 features stories
And each story should have thumbnail associated with it
And when I click a story then I should be taken to view it's details