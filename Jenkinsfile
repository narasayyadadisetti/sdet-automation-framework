pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.tags="@smoke"'
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber.html',
                reportName: 'Cucumber Test Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        }
    }
}
