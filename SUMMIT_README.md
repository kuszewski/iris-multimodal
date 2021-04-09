# Java Client Demo for Virtual Summit 2020

This code is provided as a companion to InterSystems Virtual Summit 2020 session DEE001 "IRIS Java Client SDK – Learn all the ways you can connect your Java application to IRIS"

## Simplified Clinical Trial Application
The demo shows how to use the XEP, JDBC, and Native APIs in the context of a simplified clinical trial application.

The data model consists of three parts:
1. Participant - This is a person who has agreed to be in the trial.  In this case, we just have a name and data-of-birth.
2. Cohort - This is a named group of participants.
3. TestResult - This is a test result for a participant.

There are 6 steps to the simplified clinical trial (and the demo)
1. Create the database schema
2. Enlist the participants
3. Create the cohorts
4. Assign participants to cohorts
5. Do testing
6. Report results

Notes:
* The Participant and Cohort objects are created through XEP, which is InterSystem's object-oriented API.
* TestResult's schema is created through JDBC and populated via the IRIS Native API.
* Participants are assigned to cohorts through the IRIS Native API.
* Reporting is done through JDBC

## How to run the demo

This repository is a Java maven application.  You'll need both java 8 and maven installed.

### Cache the IRIS client libraries

You also need to have the InterSystems IRIS Java client libraries as part of your maven cache.  If you haven't done so already, this can be done by a command similar to this:
```
mvn install:install-file -Dfile=c:\InterSystems\IRIS\dev\java\lib\JDK18\intersystems-jdbc-3.1.0.jar -DgroupId=com.intersystems -DartifactId=intersystems-jdbc -Dversion=3.1.0 -Dpackaging=jar -DgeneratePom=true
```

### Configuring the code

Review `App.java` to make sure that the connection details and namespace are correct to connect to your IRIS instance.  Note:  The namespace probably doesn't exist on your instance, so either change it to one that you have or create it.

### Install the SummitAssigner.cls

Import `SummitAssigner.cls` into your IRIS instance.

### Run the demo

Now you should be able to build and run the demo"
```
mvn compile exec:java -Dexec.mainClass="summit._Main"
```

## Further reading

To learn more about developing with Java in InterSystems IRIS, please see our online training materials:

* https://www.intersystems.com/resources/detail/intersystems-and-java-quickstart/
* https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=AFL_XEP
* https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=AFL_DBNATIVE
* https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=AFL_JDBC
