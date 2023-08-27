# spring-activiti-unit-tests
Basic unit tests of spring activiti with spring boot for managing workflows

# Spring Activiti Workflow Testing Example

This repository provides an example of how to test a workflow using the Spring Boot framework and the Activiti BPMN engine. The project demonstrates various test scenarios for a BPMN process defined in the **"one-task-process.bpmn20.xml"** file located at `src/main/resources/processes/one-task-process.bpmn20.xml`.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Spring Activiti Version](#spring-activiti-version)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Contributing](#contributing)

## Prerequisites

Before you begin, ensure you have the following prerequisites:

- Java Development Kit (JDK) 8 or higher
- Maven
- An understanding of BPMN and Spring Boot concepts

## Spring Activiti Version

This project is based on Spring Activiti version 6.

## Getting Started

1. Clone this repository to your local machine:

```shell
   git clone https://github.com/your-username/spring-activiti-workflow-testing.git
```

2. Navigate to the project directory:

```shell
  cd spring-activiti-workflow-testing
```

3. Build the project using Maven:

```bash
   mvn clean install
```

## Running Tests

To run the tests, execute the following command:

```bash
   mvn test
```

This command will trigger the execution of the test classes located in the `src/test` directory.

## Test Scenarios

The project contains several test scenarios that showcase how to test a BPMN workflow using Spring Boot and the Activiti BPMN engine:

1. **should_start_process:**
   Tests if a process instance can be started successfully.

2. **should_get_tasks:**
   Verifies that tasks within the process can be retrieved.

3. **should_audit_unfinished_processes:**
   Ensures that unfinished (running) process instances can be audited.

4. **should_audit_finished_processes:**
   Audits finished process instances and completed tasks.

5. **should_audit_task_activities:**
   Focuses on auditing task activities within the process.

## Contributing

Contributions to this project are welcome. If you have any suggestions, bug reports, or improvements, feel free to open an issue or submit a pull request.

---

This example demonstrates how to test a BPMN workflow using Spring Boot and the Activiti BPMN engine. It provides a clear understanding of writing and running tests to ensure the correctness of your workflow processes. If you have any questions or need further assistance, please feel free to reach out.
