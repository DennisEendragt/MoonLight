pipeline {
  agent {
    docker {
      image 'cirrusci/android-sdk:tools'
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
    stage('Stage assemble') {
      steps {
        sh './gradlew clean build -x lint --stacktrace'
      }
    }
  }
}
