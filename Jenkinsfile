pipeline {
  agent any
  stages {
    stage('Stage Checkout') {
      steps {
        sh 'git submodule update --init --recursive'
      }
    }
    stage('Stage Build') {
      steps {
        sh './gradlew clean build --stacktrace'
      }
    }
  }
}