pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo "hellooo worldddd"
            }
        }
        stage('Checkout') {
            steps {
                script {
                    echo "Checking out branch: ${env.BRANCH_NAME}"
                    git branch: 'main', url: 'git@github.com:yomnalayouni/5infini1-4.git', credentialsId: 'credJk'
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
