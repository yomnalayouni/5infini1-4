pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out branch: ${env.BRANCH_NAME}"
                git branch: 'main', url: 'https://github.com/yomnalayouni/5infini1-4.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the project on branch: 'main'"
                sh './mvnw clean install'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests on branch: 'main'"
                sh './mvnw test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying the project from branch: 'main'"
                // Add your deployment logic here
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
