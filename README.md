# DEMOQA Automation Project

This project automates the testing of the https://demoqa.com/automation-practice-form website. Visually checks page loading, validates empty fields, phone number validity. 
Fills out the authorization form and verifies that the information entered in the form popup is accurately reflected. using Playwright and POM (Page Object Model). The framework supports UI automation, and the tests are written in Java using TestNG.


## Project Structure
```
src
  /main
    /java  - 
      /data - Constants - Contains base URL.
        /pages - FormPage - Contains information about the addresses of elements
          /steps  - FormPageSteps - Contains page object classes for pages of the https://demoqa.com/automation-practice-form website.
        
  /test
    /java
      /ge.tbc - BaseTest - Contains information for Playwright about opening and closing the Chromium browser in full screen for visual display, separately for each test
        /ge.tbc  - Tests - LoginTests conteins all test cases Contains TestNG configuration files.
        



## Prerequisites

- Java 17 
- Maven
- IntelliJ IDEA or any other preferred IDE
  




## Running Tests

To run the tests, use the following command:
```sh 
mvn clean test
``` using Playwright and POM (Page Object Model). The framework supports UI automation, and the tests are written in Java using TestNG.


