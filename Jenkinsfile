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
        sh """
          mvn --version
          gradle --version
          docker info
        """
    }

    stage("Build") {
        sh """
          mvn clean install -Dmaven.test.skip=true
        """
    }
  }
}