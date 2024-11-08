pipeline {
    agent any
    tools {
        maven "MAVEN3"
    }
    environment {
        DOCKERHUB_PWD = credentials("Credential_dockerHubPWD")
    }
    stages {
        stage("Build Maven") {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/ArunaRaviKumar5/Comp367_lab2']]
                )
                bat 'mvn clean install'
            }
        }
        stage("Build Docker image") {
            steps {
                bat 'docker build -t devops/spring-devops .'
            }
        }
        stage("Push Docker image") {
            steps {
                script {
                    withCredentials([string(credentialsId: 'Credential_dockerHubPWD', variable: 'dockerhubpwd')]) {
                        bat '''
                            docker login -u arunaravikumar5 -p %dockerhubpwd% 
                        '''
                    }
                    bat 'docker push devops/spring-devops'
                }
            //   bat 'docker tag devops/spring-devops devops/spring-devops'
            //     bat 'docker push devops/spring-devops'
            }
        }
    }
}
