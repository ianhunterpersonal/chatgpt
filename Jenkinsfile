pipeline {
    agent {
        label 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/<username>/<repository>.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}
