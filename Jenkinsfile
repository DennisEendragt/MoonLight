pipeline {
  agent any
  
  stages {
      stage('Stage Checkout') {
      steps {
        sh 'chmod +x gradlew'
        sh 'git submodule update --init --recursive'
      }
    }
  }
}
