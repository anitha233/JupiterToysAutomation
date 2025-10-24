

Automated UI test suite for the [Planit Jupiter Toys](https://jupiter.cloud.planittesting.com) web application using **Selenium**, **TestNG**, and **Maven**.  
This framework supports both **local execution** and **CI/CD automation** through **Jenkins**.

Overview:

This project automates functional test cases for Jupiter Toys using the **Page Object Model (POM)** design pattern.

Tests include:
- Contact form validation and success messages  
- Cart operations and total calculations  
- Product price verification  

All tests can be executed locally or integrated into a Jenkins CI pipeline.


Tech Stack :

| Component | Version | Description |
|------------|----------|-------------|
| Java | 17 | Programming language |
| Maven | 3.9.9 | Build and dependency management |
| Selenium WebDriver | 4.36.0 | UI test automation |
| TestNG | 7.x | Test framework |
| Allure | 2.x | Test reporting |
| Jenkins | Latest | Continuous Integration tool |

---

Run all TestNG tests:

mvn clean test


Run a specific test class:

mvn -Dtest=ContactTests test


Run in headless mode (no browser window):

mvn clean test -Dheadless=true


(Headless execution is handled inside WebDriver setup — the browser will run in the background.)

Go to Manage Jenkins → Global Tool Configuration

JDK → Add jdk-17

Maven → Add maven 3.9.9

Go to Manage Jenkins → Credentials → Global credentials (unrestricted)
Add a Secret Text or GitHub token and note its ID → use github-token

Create a new Pipeline job

In Jenkins, click New Item → Pipeline → OK

Scroll to Pipeline script from SCM

Choose Git

Paste the repository URL:

https://github.com/anitha233/JupiterToysAutomation.git


Add credentials → select github-token

Set Branch Specifier to */main

Jenkins will automatically detect and run the pipeline defined in Jenkinsfile

