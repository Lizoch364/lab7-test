pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk17'
    }

    stages {
        stage('Checkout & Build') {
            steps {
                git 'https://github.com/ВАШ_ЛОГИН/lab7.git'
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