pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo "hellooo worldddd"
                // Add your deployment logic here
            }
        }
         stage('Checkout') {
            steps {
                script {
                    echo "Checking out branch: ${env.BRANCH_NAME}"
                    // Update the URL and branch name as needed
                    git branch: 'main', url: 'https://github.com/yomnalayouni/5infini1-4.git'
                }
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
