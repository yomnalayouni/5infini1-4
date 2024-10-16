/*pipeline {
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
*/
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Remplacer 'mayssen-dridi-bloc' par le nom de votre branche
                git branch: 'mayssen-dridi-bloc', credentialsId: 'tokenjen', url: 'https://github.com/yomnalayouni/5infini1-4.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                // Ajoutez ici vos commandes de build, par exemple :
                sh 'mvn clean install'
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
                // Ajoutez ici vos commandes de test
                // Par exemple : sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Ajoutez ici vos commandes de déploiement
            }
        }
    }
    post {
        always {
            echo 'This runs after all stages.'
        }
    }
}
