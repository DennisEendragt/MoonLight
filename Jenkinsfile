pipeline {
  agent {
    docker {
      image 'cirrusci/android-sdk:tools'
      args '-v gradle-repo:/root/.gradle -v ANDROID_HOME:/root/opt/android-sdk-linux'
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
    stage('Stage Test') {
      steps {
        sh './gradlew test'
      }
    }
    stage('Stage Verify') {
      steps {
        withSonarQubeEnv('SonarQube') {
          sh './gradlew sonarqube -Dsonar.projectKey=DennisEendragt_MoonLight -Dsonar.organization=denniseendragt-github -Dsonar.c.file.suffixes=--Dsonar.cpp.file.suffixes=- -Dsonar.objc.file.suffixes=-'
        }
      }
    }
  }
}
