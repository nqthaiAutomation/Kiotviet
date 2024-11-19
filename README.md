# SerenityCucumberJUnit4_Demo

This is a sample application to demonstrate how to setup and run Serenity, Cucumber tests with JUnit4 in Web application.

1. This framework consists of:
````
Serenity – 2.0.87
Java 11
Junit – 4.12
Serenity Cucumber - 1.9.45
Maven Compiler Plugin - 2.19.1
Maven Surefire Plugin - 2.19.1
Maven – 3.9.9
````

2. To run the tests through command line, use the command
````
mvn clean verify
````

3. Reports This framework contains sample Serenity Reports under target/site/serenity folder.

4. To run the tests in chrome, use the below command
````
mvn clean verify -Denvironment=chrome
````

5. To run the tests in firefox, use the below command
````
mvn clean verify -Denvironment=firefox
````

6. To run the tests in edge, use the below command
````
mvn clean verify -Denvironment=edge
````
