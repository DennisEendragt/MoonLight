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
      steps {
        sh '''git update-index --chmod=+x gradlew
'''
      }
    }
  }
}