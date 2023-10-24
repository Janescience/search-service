pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    environment {
        DOCKER_HOME = '/usr/local/bin/docker'  // Path to the Docker executable
        KUBECTL_HOME = '/usr/local/bin/kubectl'  // Path to the Docker executable
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Janescience/search-service']]])
                sh 'mvn clean install'
            }
        }
        stage('Build image'){
            steps{
                script{
                    sh '${DOCKER_HOME} build -t search-service:latest .'
                }
            }
        }
        
        stage('Push image to Hub'){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-pwd', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh '${DOCKER_HOME} login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}'
                        sh '${DOCKER_HOME} tag search-service:latest janescience/search-service:latest'
                        sh '${DOCKER_HOME} push janescience/search-service:latest'
                        sh '${DOCKER_HOME} rmi -f $(${DOCKER_HOME} images -f "dangling=true" -q)'
                    }
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'k8s/deployment.yml',kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'k8s/service.yml',kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'k8s/scaled-object.yml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        
        }
    }
}

