def gitRepo = 'https://github.com/piinalpin/graphql-spring-boot.git'
def gitBranch = 'master'
def jenkinsCredentialsID = 'test-jenkins-github'

pipeline {
  agent {label "linux"}
  stages {
    stage("Checkout") {
        steps {
            git url: "${gitRepo}", branch: "${gitBranch}", credentialsId: "${jenkinsCredentialsID}"
        }
    }
    
    stage("Run Test") {
        steps {
            sh """
                mvn --version
                gradle --version
                docker info
            """
        }
    }

    stage("Build") {
        steps {
            sh """
                mvn clean install -Dmaven.test.skip=true
            """
        }
    }

    stage("Package") {
        steps {
            sh """
                mvn clean package -Dmaven.test.skip=true
            """
        }
    }
  }
}