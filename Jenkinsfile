pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo "hellooo worldddd"
            }
        }
        stage('Add GitHub to Known Hosts') {
            steps {
                script {
                    sh '''
                    mkdir -p ~/.ssh
                    ssh-keyscan github.com >> ~/.ssh/known_hosts
                    '''
                }
            }
        }
        stage('Checkout') {
            steps {
                script {
                    echo "Checking out branch: ${env.BRANCH_NAME}"
                    git branch: 'main', url: 'git@github.com:yomnalayouni/5infini1-4.git'
                }
            }
        }
        stage('CheckoutY') {
            steps {
                script {
                    echo "Checking out branch: ${env.BRANCH_NAME}"
                    git branch: 'yomna-layouni-etudiant', url: 'git@github.com:yomnalayouni/5infini1-4.git'
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
