# demo_sec

To execute, clone the project to your local folder:

Go to the root (pom file) and run the following to install dependencies:

        mvn install
    
Once installed, run the following to execute test case:

        mvn clean verify serenity:aggregate
    
Once done, please check the results from index.html under ./target and click on Feature link to get to the screenshots and details of each executed step

Following dependencies were used:
    - Apache Maven 3.6.0
    - Java version: 1.8.0_121 (jdk1.8.0_121)
    - Default locale: en_AU, platform encoding: Cp1252

*Avoid Plugin Descriptor warning message while the project installs the dependencies.
*Chrome version ^74
