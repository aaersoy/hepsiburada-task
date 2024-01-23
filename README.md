# Project Overview

This project is developed using Java 17 and incorporates Maven for dependency management and build automation. It employs the Rest Assured framework, version 4.3.1, and uses Gauge for reporting purposes.

## Prerequisites

- **Java 17**: Essential for running the project. Ensure that Java 17 is installed and properly configured on your system.
- **Maven**: Utilized for managing dependencies and executing build scripts. It is recommended to use Maven version 3.6.0 or higher.
- **Gauge**: For Allure installation, the command `brew install gauge` is sufficient.

## Configuration

The settings for executing tests in headless mode or with specific browser options can be adjusted in `config.properties`. This feature facilitates easy modifications to accommodate different testing environments.

## Getting Started

After installing and configuring Java, Maven, and Gauge, the project can be built and tested by executing the following command in the terminal:

1. `mvn clean install`

These commands will initiate the building and testing processes, and subsequently generate a report using Gauge.

HTML report is located under `reports` folder.
