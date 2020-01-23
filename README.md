# WordPressCMS Automated UI Tests
This repository contains automated tests for the WordPress CMS application

### What do I need?
This should download everything for you, but the following may be useful anyway:
1. Eclipse IDE

### Core dependencies
1. Selenium Java
2. TestNg
3. Install Maven

### Installation on WINDOWS
1. Download java and set Java_Home in environment variables
2. Clone this repository to your local machine
3. Install eclipse - Import the wordpressCMS project from where you cloned it on your local
4. Download selenium java libraries``

#### Architecture (Maven Project)
Framework is divided in such subsections:

**Page Object Repositories** - they contain elements on each referenced page of the WordPress application and the methods required to test the different features of the application.
`src/main/java/WordPressCMS/WordPressCMS/***Repo.java`

**Browser Selector Class** - it contains the method to launch your browser and navigate to the WordPress application base url in any desired browser e.g. chrome, firefox or internet explorer.
`src/main/java/WordPressCMS/WordPressCMS/BrowserSelector.java`

**Test Classes** - they contain various test cases to execute for our test of the different features of the WordPress application. 
`src/main/test/WordPressCMS/WordPressCMS/***Test.java`

**Pom File** - The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals etc

**Testng.xml** - Here you define execution order of your tests. It is used to define test suites and tests. It is also used to pass Parameters to the test methods.

#### Execution
**Testng.xml**
From within the wordpressCMS project folder in your Eclipse IDE, Right click on testng.xml file and select TestNG Suite under Run AS.

**Maven Test**
From Eclipse IDE, Right click on the wordpressCMS project folder, select Run As, you can choose either Maven test or Maven install to run the tests, or run via command line using mvn install
