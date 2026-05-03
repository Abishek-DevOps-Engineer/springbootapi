pipeline{
    agent {
        label 'javanode'
    }
    environment{
        IMAGE_NAME = 'springapp:latest'
        SONAR_TOKEN = credentials('sonartoken')
        DOCKERHUB_IMAGE = 'abishek1710/springbootapi:latest'
        DOCKER_TOKEN = 'dockertoken'
    }
    stages{
        stage('Git Checkout'){
            steps{
                git branch: 'main', credentialsId: 'githubsecrect', url: 'https://github.com/Abishek-DevOps-Engineer/springbootapi'
            }
        }
		stage('Maven build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('Sonar scanner'){
            steps {
                withSonarQubeEnv('sonarserver') {
                    sh '''
                        mvn sonar:sonar \
                            -Dsonar.projectKey=springbootapi \
                            -Dsonar.projectName=springbootapi \
                            -Dsonar.host.url=$SONAR_HOST_URL \
                            -Dsonar.token=$SONAR_TOKEN \
                            -Dsonar.sources=src/main/java \
                            -Dsonar.tests=src/test/java \
                            -Dsonar.java.binaries=target/classes
                    '''
                }
            }
        }
        stage('Docker Image build'){
            steps{
                sh 'docker build -t $IMAGE_NAME .'
            }
        }
        stage('Docker Image Push'){
            steps{

                withCredentials([usernamePassword(credentialsId: DOCKER_TOKEN, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USER')]) {
                    sh 'docker login -u $DOCKER_USER -p $DOCKER_PASSWORD '
                    sh 'docker tag $IMAGE_NAME $DOCKERHUB_IMAGE'
                    sh 'docker push $DOCKERHUB_IMAGE'
                }




            }
        }
        stage('Deploy'){
            steps{
                sh 'docker pull $DOCKERHUB_IMAGE'
                sh 'docker run -d -p 8080:8081 --name restapiapp $DOCKERHUB_IMAGE'
            }
        }
    }
    post {

        success{
            echo "Success"

        }
        failure{
            echo "failure"
        }
    }
}