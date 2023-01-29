pipeline {

	environment {
		imagename = "ianhunterpersonal/chatgpt"
		registryCredential = 'dockerhub'
		dockerImage = ''
        JAVA_HOME = '/Users/developer/.sdkman/candidates/java/current'
	}

    agent any
    stages {
    
         stage('Setup parameters') {
	         steps {
	             script { 
	                 properties([
	                     parameters([
	                         booleanParam(
	                             defaultValue: false, 
	                             description: '', 
	                             name: 'CI'
	                         )
	                     ])
	                 ])
	             }
         	}
         }
            
        stage('Clean') { 
            steps { 
               sh 'echo "Cleaning..."; mvn clean'
            }
        }
        stage('Compile') { 
            steps { 
               sh 'echo "Compile..."; mvn compile'
            }
        }
        stage('Test') { 
            steps { 
               sh 'echo "Testing..."; mvn test'
            }
        }
        stage('Package') { 
            steps { 
               sh 'echo "Testing..."; mvn package'
            }
        }

        stage('Building image') {
			  steps {
			   sh 'echo "Building image...."'
				script {
					dockerImage = docker.build imagename
					echo "${dockerImage}"
				}
			 }
		  }
		  
	    stage('Deploy Image') {
	      steps{
	        script {
	          docker.withRegistry( '', registryCredential ) {
	            dockerImage.push("$BUILD_NUMBER")
	            dockerImage.push('latest')
	          }
	        }
	      }
	    }
	    
	    stage('Remove Unused docker image') {
	      steps {
	         sh "docker rmi $imagename:$BUILD_NUMBER"
	         sh "docker rmi $imagename:latest"
	      }
	    }        
	}
}