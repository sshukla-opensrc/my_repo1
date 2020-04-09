#!groovy

pipeline {
    agent {
        node {
            label 'master'
            customWorkspace "workspace/${env.BUILD_TAG}"
        }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                    script {
                    echo 'Testing..'
                    sh '/path/to/my/file/test.sh ';
                }
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == 'SUCCESS'
              }
            }
            steps {
                echo 'Deploying....'
            }
        }
    }
}
