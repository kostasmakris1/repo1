To run the tests you will need java jdk8 and maven installed.
Download the project and navigate to the directory where the pom.xml file is and
run the following command:
mvn clean install -DbrowserName=chrome
To run the tests from an IDE you will need to set the VM arguments to -DbrowserName=chrome under "run configuration"

These tests have not been tested on Mac OS
