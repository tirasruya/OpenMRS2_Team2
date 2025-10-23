# OpenMRS Test Automation Project

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Tests Status](https://img.shields.io/badge/tests-passed-brightgreen) ![Allure Report](https://img.shields.io/badge/report-allure-blue)

## 📘 Overview

This repository contains automated UI tests for the OpenMRS healthcare management system. The objective of this project is to ensure that the system’s core functionalities—such as authentication, patient management, and appointment scheduling—operate as expected.

All automated tests are executed on the official OpenMRS Demo Environment:
🔗 [OpenMRS Demo](https://o2.openmrs.org/openmrs/login.htm)

## 🧩 Automated User Stories

| ID     | Title                            | Description                                                                     | Group                          |
| ------ | -------------------------------- | ------------------------------------------------------------------------------- | ------------------------------ |
| US_401 | Login Error Validation           | Verifies that invalid login attempts display proper warning messages.           | Smoke, Login                   |
| US_402 | Successful Login                 | Ensures users can log in with valid credentials.                                | Smoke, Login                   |
| US_403 | Logout Functionality             | Confirms that users can log out securely and return to the login page.          | Smoke, Logout                  |
| US_404 | Patient Registration             | Tests the process of adding a new patient with demographic and contact details. | Regression                     |
| US_405 | Account Access                   | Validates that account settings and related options are accessible after login. | Smoke                          |
| US_406 | Patient Search                   | Ensures that patients can be located by name or ID.                             | Patient Management             |
| US_407 | Patient Deletion                 | Verifies that authorized users can delete a patient record.                     | Smoke, Patient Management      |
| US_408 | List of Patients                 | Checks that all patients are correctly listed with an accurate total count.     | Regression                     |
| US_409 | Merge Patient Records            | Tests merging of duplicate patient profiles into a single record.               | Regression, Patient Management |
| US_410 | Appointment Time Zone Validation | Ensures that incorrect time zone settings trigger a relevant warning message.   | Regression, Appointment        |

## 🧰 Technology Stack

* **Language:** Java
* **Frameworks:** Selenium WebDriver, TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting Tools:** Allure / Extent Reports
* **Supported Browsers:** Chrome, Firefox, Safari
* **Environment:** [OpenMRS Demo](https://o2.openmrs.org/openmrs/login.htm)

## ⚙️ Setup & Execution

1. Clone the repository:

```bash
git clone https://github.com/tirasruya/OpenMRS2_Team2.git
```

2. Navigate to the project directory:

```bash
cd openmrs-automation
```

3. Install dependencies:

```bash
mvn clean install
```

4. Run test suites:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## 🧪 Testing Approach

* Structured using the Page Object Model for maintainable and scalable test code.
* Tests are grouped into Smoke, Regression, and Patient Management categories.
* Uses TestNG `@DataProvider` for data-driven scenarios.
* Priorities define execution order, ensuring critical flows are tested first.
* Generates comprehensive Allure/Extent HTML reports after execution.

## ✅ Key Validation Points

* UI component visibility and accessibility
* Accurate success and error message handling
* Positive and negative scenario validation
* Cross-browser consistency checks
* Dynamic and reusable page methods with synchronization using explicit waits

## 📂 Project Structure

```
openmrs-automation/
│
├── src/
│   ├── main/java/pages/          # Page Object Models
│   ├── test/java/tests/          # Automated test classes
│   └── test/resources/           # Test data and configuration files
│
├── pom.xml                       # Maven project configuration
├── testng.xml                    # Test suite definition
├── README.md                     # Documentation
└── reports/                      # Test execution reports
```

## 👩‍💻 Author

Test Automation Engineer: Ruya Tiras
