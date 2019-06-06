pipeline {
  agent {
    docker {
      image 'jenkinsci/blueocean'
    }

  }
  stages {
    stage('Stage Checkout') {
      steps {
        sh 'git submodule update --init --recursive'
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
        stage('Stage assemble') {
          steps {
            sh './gradlew clean build --stacktrace'
          }
        }
      }
    }
  }
}