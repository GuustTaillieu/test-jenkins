pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven'
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Declarative: Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Clean Install') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t sweetmustard/hello:latest .'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker stop hello-container || true'
                    sh 'docker rm hello-container || true'
                    sh 'docker run -d -p 8080:8080 --name hello-container sweetmustard/hello:latest'
                }
            }
        }
    }
}
