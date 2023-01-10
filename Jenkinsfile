pipeline {
    agent any
    stages {
        stage ('Build backend') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage ('Unit Testes') {
            steps {
                sh 'mvn test'
            }
        }
    }
}