# WordPressCMS Automated UI Tests
This repository contains automated tests for the WordPress CMS application

### What do I need?
1. Eclipse IDE
2. Java SDK
3. Maven

### Core Dependencies
1. Selenium Java
2. TestNg
3. Maven Surefire plugin

### Setup / Installation on WINDOWS
1. Download Java and set Java_Home in environment variables
2. Clone this repository to your local machine
3. Install Eclipse IDE
4. From Eclipse IDE, Import the wordpressCMS project from where you cloned it on your local
5. Select File from the Menu bar
6. Select Import
7. Click Maven
8. Select Existing Maven Projects
9. Browse to the location of the cloned wordPressCMS project folder and select it
10. Check the project displayed in the Projects section
11. Click on Finish
12. Update your project with dependencies and plugins from the pom.xml file
13. Right-click on the WordPressCMS project folder
14. Click Maven
15. Click Update Project
16. Voila! You can proceed to run the tests using the steps in the Execution section of this document

### Architecture of the WordPress CMS Automated Tests (Maven Project)
The Framework is structured as highlighted below:

**Page Object Repositories** - they contain elements on each referenced page of the WordPress application and the methods required to test the different features of the application.
`src/main/java/WordPressCMS/WordPressCMS/***Repo.java`

**Browser Selector Class** - it contains the method to launch your browser and navigate to the WordPress application base URL in any desired browser e.g. chrome, firefox, or Internet Explorer.
`src/main/java/WordPressCMS/WordPressCMS/BrowserSelector.java`

**Test Classes** - they contain various test cases to execute for our test of the different features of the WordPress application. 
`src/main/test/WordPressCMS/WordPressCMS/***Test.java`

**pom.xml File** - The pom.xml file contains project and configuration information for maven to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals, etc

**testng.xml** - Here you define the execution order of your tests. It is used to define test suites and tests. It is also used to pass Parameters to the test methods.

### Tests Execution
**Using testng.xml file**
From within the wordpressCMS project folder in your Eclipse IDE, Right click on the testng.xml file and select TestNG Suite under Run AS.

**Using Maven**
From Eclipse IDE, Right click on the wordpressCMS project folder, and select Run As, you can choose either Maven test or Maven install to run the tests, or run via the command line using mvn install
