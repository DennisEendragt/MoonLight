pipeline {
  agent { label 'master' }
  stages {
    stage('Stage Checkout') {
      steps {
        sh 'git submodule update --init --recursive'
      }
    }
    stage("Run with JDK 8 and gradle") {
      agent {
        docker {
          image 'cangol/android-gradle'
          args '-v gradle-repo:/root/.gradle'
          reuseNode true
        }
      }
      stages {
        stage("Build") {
          steps {
            sh "gradle clean build"
          }
        }
        stage("Test") {
          steps {
            sh "gradle test"
          }
        }
      }
    }
  }
}
