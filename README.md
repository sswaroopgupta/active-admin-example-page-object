# Selenium example in Java

[![Build Status](https://travis-ci.org/getgauge/gauge-example-java.svg?branch=master)](https://travis-ci.org/getgauge/gauge-example-java)
[![HTML report](https://img.shields.io/badge/report-html-green.svg)](http://gauge-example-reports.herokuapp.com/java)
[![Console report](https://img.shields.io/badge/report-console-blue.svg)](http://gauge-example-reports.herokuapp.com/java/console)

This is an example project for doing web automation testing with Page Objects.
This is using [Selenium](https://en.wikipedia.org/wiki/Selenium_(software)).
This project tests some of the functionalities of the [active admin demo](https://github.com/getgauge/activeadmin-demo) app. This app is hosted as a Java WAR (with embedded Jetty).

## Running this example
The tests are run on Chrome by default.

### Prerequisites

This example requires the following softwares to run.
  * [Java 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or above
  * Chrome

### Setting up the System Under Test (SUT)

* Download [activeadmin-demo.war](https://bintray.com/artifact/download/gauge/activeadmin-demo/activeadmin-demo.war)
* Bring up the SUT by executing the below command
```
java -jar activeadmin-demo.war
```
* The SUT should now be available at [http://localhost:8080/](http://localhost:8080)

### Setting up Maven

* [Maven installation instructions](http://maven.apache.org/install.html)

## Run specs

If you already have Maven installed, you can execute specs as `mvn test`

This uses Chrome as default browser for specs execution. Make sure Chrome is installed in your machine and [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/) is in PATH.

# Copyright
Copyright 2016, ThoughtWorks Inc.
