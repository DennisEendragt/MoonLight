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
          image 'gradle:3.4-jdk8'
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
       
        // post {
          // always {
            // archiveArtifacts artifacts: 'target/**.jar', fingerprint: true
            // junit 'target/surefire-reports/**.xml'
          // }
        // }
      }
      stage("Verify") {
        agent {
          docker {
            image 'gradle:3.4-jdk8'
            args '-v gradle-repo:/root/.gradle -v sonar-repo:/root/.sonar' // This is important for demo purposes
            reuseNode true
          }
        }
        steps {
          echo 'kom nog'
          // withSonarQubeEnv("sonarcloud") {

          //   // doe hier je eigen repo ik help je met de env
          //   // sh "mvn sonar:sonar -Dsonar.projectKey=Samper1022_asv-swagger-codegen -Dsonar.organization=samper1022-github"
          // }
          //   sleep(10) // Another hack because of webhook issues
          //   timeout(time: 30, unit: "MINUTES") {
          //   waitForQualityGate abortPipeline: true
          // }
        }
      }
    }
  }
}
