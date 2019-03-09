#!/usr/bin/env groovy

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

        stage('Build') {

        	sh 'mvn clean install'
        }

        stage('Test') {

        	sh 'mvn test'
        }

        stage('Package') {

        	sh 'mvn package'
        }
        
        stage('Deploy') {

        	echo 'Here we will deploy'
        }
        
        stage('Directory') {
            steps {
                sh 'ls'
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