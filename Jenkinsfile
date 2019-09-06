pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        sh 'echo "This is a placeholder, Sowy :3"'
      }
    }
    stage('Health-check') {
      steps {
        sh 'echo "This is also a placeholder"'
      }
    }
  }
}