pipeline {
   agent {
        label 'docker'
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
            sh "chmod +x gradlew"
            sh "./gradlew build"
          }
        }
        stage('Stage assemble') {
          steps {
            sh "./gradlew test"
          }
        }
      }
    }
  }
}
