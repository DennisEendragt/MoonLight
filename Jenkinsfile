pipeline {
  agent {
    docker {
      image 'jenkinsci/blueocean'
    }

  }
  stages {
    stage('Checkout') {
      steps {
        sh 'git submodule update --init'
      }
    }
  }
}