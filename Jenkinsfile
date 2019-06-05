pipeline {
  agent {
    docker {
      image 'jenkinsci/blueocean'
    }

  }
  stages {
    stage('Stage 1') {
      steps {
        sh '  sh \'git submodule update --init\' '
      }
    }
  }
}