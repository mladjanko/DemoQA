# DemoQA
## https://demoqa.com/
## DemoQA is a website that provides free resources for learning various software testing tools, test automation frameworks, and QA methodologies.
## This is my test automation demo project written in Java and it's still under the development.

## Dependencies
* Run on Windows 10, 11 OS
* IDE for this project is IntelliJ IDEA 2025.1 (Community Edition)
* Browsers needed is Chrome as mandatory

## Instalation

Open terminal in IDE and git clone the repository

```
git clone https://github.com/mladjanko/DemoQA.git
```
* Java version 24
* Apache Maven 4.0.0

## Executing program

## Framework Walkthorugh
Packages:
* Base - Contains classes used through the app
* Helpers - Contains classes that could be useful for DDT
* Pages - Contains classes for each page
* Tests - Contains test classes

Files:
* pom.xml - Contains all dependencies used in the project (last updated: 10.4.2025.)
* DemoQATestData.xlsx - Excel file used to read data for DDT as an alternative
* yoda.jpg - JPG file used for some tests
* .gitignore - File used to store all items that are not pushed to github

## Naming convention
* Classes are written in camel case with first character in upper case
* Methods are written in camel case with first character in lower case
* Class objects are named the same as a class name with lower case for first character
* Test methods are named as test case names

## Other
* Test methods are kept clean
* Each test should have at least 2 assertions with few test exceptions
* Priorities are set with 10 increment, if higher priority occur later in testing, priority of such tests are placed between the two priorities

# To be continued!