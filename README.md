BBC News - Cucumber Framework
===================


Overview
--------

BBC News is automated using Selenium webdriver, Cucumber JVM as automation framework, PageObject design pattern and Maven is used as build tool. 

Once the test is completed the result will be available under target folder.


SetUp Details
-----------------

Download Chrome driver from below location
https://code.google.com/p/chromedriver/downloads/list?can=1&q=

Copy Chrome driver file in the below location

<parent Directory>\src\main\resources

Only for MAC & Linux

Change the chrome driver file name in CHROME_LOCATION

<parent Directory>\src\test\java\co\uk\bbc\news\test\StartUp.java

CHROME_LOCATION = "src/main/resources/chromedriver"



Execution Details
-----------------

Run the below mvn command to start the test execution

1. To run the Regression test on Production (Firefox browser)

    mvn clean test -Denvironment=prod -Dbrowser=firefox -Dcucumber.options="--tags @Regression" exec:java

2. To run the Regression test on Production (Chrome browser)

    mvn clean test -Denvironment=prod -Dbrowser=chrome -Dcucumber.options="--tags @Regression" exec:java

Test Report
-----------

Cucumber report will be generated and available in the below location,

1. Cucumber Report
	/target/cucumber/index.html

2. Cucumber Jenkins Report
	/target/cucumber-html-reports/feature-overview.html
