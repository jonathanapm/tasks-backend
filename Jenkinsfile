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

        stage ('API Test') {
            steps {
                dir ('api-test') {
                    git credentialsId: 'github_login', url: 'https://github.com/jonathanapm/tasks-api-test'
                    sh 'mvn test'
                }
            }
        }
    }
}