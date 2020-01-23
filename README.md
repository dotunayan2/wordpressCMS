# WordPressCMS Automated UI Tests
This repository contains automated tests for the WordPress CMS application

### What do I need?
This should download everything for you, but the following may be useful anyway:
1. Eclipse IDE
2. Java SDK
3. Maven

### Core dependencies
1. Selenium Java
2. TestNg
3. Maven Surefire plugin

### Setup / Installation on WINDOWS
1. Download java and set Java_Home in environment variables
2. Clone this repository to your local machine
3. Install eclipse IDE
4. From Eclipse IDE, Import the wordpressCMS project from where you cloned it on your local
>>> Select File from the Menu bar 
>>> Import 
>>> Maven 
>>> Existing Maven Projects 
>>> Browse to the location of the cloned wordPressCMS project folder and select it 
>>> Check the project displayed in the Projects section 
>>> Click on Finish
5. Update your project with dependencies and plugins from the pom.xml file
>>> Right click on the WordPressCMS project folder 
>>> Maven 
>>> Update Project
6. Voila! You can proceed to running the tests using the steps in the Execution section of this document

#### Architecture for the WordPress CMS Automated Tests (Maven Project)
The Framework is structured as highlighted below:

**Page Object Repositories** - they contain elements on each referenced page of the WordPress application and the methods required to test the different features of the application.
`src/main/java/WordPressCMS/WordPressCMS/***Repo.java`

**Browser Selector Class** - it contains the method to launch your browser and navigate to the WordPress application base url in any desired browser e.g. chrome, firefox or internet explorer.
`src/main/java/WordPressCMS/WordPressCMS/BrowserSelector.java`

**Test Classes** - they contain various test cases to execute for our test of the different features of the WordPress application. 
`src/main/test/WordPressCMS/WordPressCMS/***Test.java`

**pom.xml File** - The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals etc

**testng.xml** - Here you define execution order of your tests. It is used to define test suites and tests. It is also used to pass Parameters to the test methods.

#### Execution
**Using testng.xml file**
From within the wordpressCMS project folder in your Eclipse IDE, Right click on testng.xml file and select TestNG Suite under Run AS.

**Using Maven**
From Eclipse IDE, Right click on the wordpressCMS project folder, select Run As, you can choose either Maven test or Maven install to run the tests, or run via command line using mvn install
