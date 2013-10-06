@HomePageTabs
Feature: Navigating Between The Tabs

Background:
When I view the home page of the BBC News

@Regression @Sniff
Scenario Outline: To Verify that all the home page tabs links are working fine.
Also verify page titles are showing correctly.

When I click on the <tabname> tab
Then the title of the page displayed is <title>

Examples:
| tabname  |  title               |
| News     |  BBC News - Home     |
| Sport    |  BBC Sport - Sport   |
| Weather  |  BBC Weather         |
