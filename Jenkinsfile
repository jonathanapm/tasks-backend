pipeline {
    agent any
    stages {
        stage ('Build backend') {
            steps {
                echo 'mvn clean package -DskipTests=true'
            }
        }
    }
}