pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Build commands go here
            }
            post {
                success {
                    echo 'Build was successful!'
                }
                failure {
                    echo 'Build failed.'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Test commands go here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Deployment commands go here
            }
        }
    }
    post {
        always {
            echo 'This runs after all stages.'
        }
    }
}
