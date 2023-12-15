# Test cases for myntra.com
# using cucumber, testng and page object model

This repository contains a collection of 
regression tests for myntra.com

## Installation (pre-requisites)

1. JDK 1.8+ (make sure Java class path is set in environment variables)
2. Maven (make sure .m2 class path is set in environment variables)
3. Eclipse/Intellij
4. Intellij/Eclipse Plugins for
    - Cucumber
5. Git bash to run tests from command line

# How to run test cases [from command line or git bash terminal]
- First clone this repo, keeping same folder structure and wait for clone to finish

# To run scripts on local machine browser with tags e.g.
    mvn clean test -Dcucumber.filter.tags=@Regression
The scripts should run successfully in Chrome browser and should generate application logs

# Folder structure
**src/main/java**

    Inside this folder all framework related code is placed.
    like page object classes, hooks and Step definitions


    i. stepdefinitions -  Given When Then steps definitions are added under this package, 
                         a matching class is created for every page class.
    
    ii. pages – It consist of classes respective to each page. 
                      Implementing Page factory methodology.

**src/test/java**

    Inside this package test runner file exist. 
    
**src/test/resources**

    Resources for the test cases should be put in this folder.
    i. Features-  Here we are writing features scenarios as below