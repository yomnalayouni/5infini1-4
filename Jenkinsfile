pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo "Running tests on branch: ${env.BRANCH_NAME}"
                sh './mvnw test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying the project from branch: ${env.BRANCH_NAME}"
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
