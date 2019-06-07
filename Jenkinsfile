pipeline {
  agent {
    docker {
      image 'openjdk:8-jdk'
      args '-v gradle-repo:/root/.gradle'
      reuseNode true
    }

  }
  stages {
    stage('Stage Checkout') {
      steps {
        sh 'chmod +x gradlew'
        sh 'git submodule update --init --recursive'
      }
    }
    stage('Stage build') {
      parallel {
        stage('Stage build') {
          steps {
            echo 'test'
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
