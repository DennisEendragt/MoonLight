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
    stage('Stage Test') {
      steps {
        sh './gradlew test'
      }
    }
    stage('Stage Verify') {
      steps {
        sh './gradlew sonarqube -Dsonar.projectKey=DennisEendragt_MoonLight -Dsonar.organization=denniseendragt-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=4034cf9fc8967369b1e64f53bdaeddd1fc33991b -Dsonar.c.file.suffixes=--Dsonar.cpp.file.suffixes=- -Dsonar.objc.file.suffixes=-'
      }
    }
    stage('') {
      steps {
        waitForQualityGate(abortPipeline: true, credentialsId: '4034cf9fc8967369b1e64f53bdaeddd1fc33991b')
      }
    }
  }
}