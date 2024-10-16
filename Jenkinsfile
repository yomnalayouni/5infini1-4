pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo "hellooo worldddd"
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
