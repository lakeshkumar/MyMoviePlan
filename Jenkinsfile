pipeline {
	agent any
	tools {
		maven "Maven"
	}
	stages {
		stage('Maven Build') {
			steps {
			    checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/lakeshkumar/MyMoviePlan']]])
				sh "mvn clean install"
			}
		}
		stage("Build Docker Image") {
		    steps {
		        script {
		            sh "docker build -t mymovieplan:${BUILD_NUMBER} ."
		            sh "docker tag mymovieplan:${BUILD_NUMBER} lakeshkumar/mymovieplan:${BUILD_NUMBER}"
		        }
		    }
		}
		stage("Push Image to Hub") {
		    steps {
		        script {
		            withCredentials([string(credentialsId: 'DockerId', variable: 'Password')]) {
		            sh "docker login -u lakeshkumar -p ${Password}"
		            sh "docker push lakeshkumar/mymovieplan:${BUILD_NUMBER}"
		            }
		        }
		    }
		}
		stage("Docker Deploy") {
			steps {
				sh "docker run -itd -p 8082:8082 lakeshkumar/mymovieplan:${BUILD_NUMBER}"
			}
		}
	}
}
