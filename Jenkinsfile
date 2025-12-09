pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk17'
    }

    stages {
        stage('Checkout & Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Lizoch364/lab7-test.git'
                sh 'mvn clean compile'
            }
        }

        stage('Integration Tests') {
            steps {
                sh 'mvn test -Dtest="*IntegrationTest"'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}