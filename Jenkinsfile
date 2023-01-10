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

        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomcatLoginCorreto', path: '', url: 'http://localhost:8081/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
    }
}