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
  environment {
    GRADLE_USER_HOME = 'C:\\Users\\Local-Admin\\AppData\\Local\\Android\\Sdk'
  }
}