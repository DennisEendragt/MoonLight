pipeline {
  agent {
    docker {
      image 'jenkinsci/blueocean'
    }

  }
  stages {
    stage('Stage Checkout') {
      steps {
        sh 'git submodule update --init'
      }
    }
    stage('Stage build') {
      parallel {
        stage('Stage build') {
          steps {
            sh '''chmod +x gradlew
'''
          }
        }
        stage('error') {
          steps {
            sh './gradlew clean assemble'
          }
        }
      }
    }
  }
}