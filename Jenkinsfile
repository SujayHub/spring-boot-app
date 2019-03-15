pipeline {
    agent any

    environment {
        JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/"
        M2_HOME="/opt/maven"
        MAVEN_HOME="/opt/maven"
    }

    stages {
        
       stage('Setup') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }
        
        stage('SCM Test') {
            steps{
                
                git(
                    url: 'https://github.com/SujayHub/spring-boot-app.git',
                    credentialsId: '59b07dd7-0c41-4b29-b5c4-9c9a0dce2fd3',
                    branch: 'master'
                    )
                
            }
        }
        
        /*stage('Sonar Check'){
            steps{
                sh 'ls'
                sh 'mvn package'
                sh '''mvn sonar:sonar \\
                -Dsonar.projectKey=spring-app \\
                -Dsonar.host.url=http://35.200.148.50 \\
                -Dsonar.login=0fec5fff257d5d7da5b96a5b780f31e8dd1aacfb\\
                '''
                
            }
            
        }

        stage('Test') {

        	steps{

        	sh 'mvn test'
        		
        	}
        }

        stage('Package') {

        	steps{

        	sh 'mvn package'

        	}

        	
        }
        
         stage ('Artifactory') {
             
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: "http://35.200.146.113/artifactory/",
                    username: "user",
                    password: "MYart@0312"
                )
                
                rtUpload (
                    serverId: "ARTIFACTORY_SERVER",
                    spec:
                    """{
                        "files": [
                        {
                         "pattern": "target/*SNAPSHOT*.jar",
                         "target": "libs-snapshot-local/h2-persistance/"
                        }]
                    }"""
                )
                
            }
             
         }*/
         stage('Docker') {

        	steps{

        	sh 'mvn install dockerfile:build'

        	}
        }
        
        stage('Deploy') {

        	steps{

        	echo 'Deploying...'

        	}
        }

    }
    
    
    post {
        
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
        
    }
}
