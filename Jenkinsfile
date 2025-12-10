pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven-3.9'
    }

    environment {
            ALLURE_RESULTS = "${env.WORKSPACE}/target/allure-results"
        }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                url: 'https://github.com/tirasruya/OpenMRS2_Team2.git'
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure([
                    commandline: 'Allure',
                    results: [[path: 'target/allure-results']],
                    reportBuildPolicy: 'ALWAYS'
                ])
            }
        }
    }
}
