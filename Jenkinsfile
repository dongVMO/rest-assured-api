
pipeline {
    agent any

    tools {
        maven '3.8.1'
        allure 'Allure report'
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }

            post {
                always{
                    script{
                        allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'allure-results']]
                        ])
                    }
                }
            }
        }
    }
}