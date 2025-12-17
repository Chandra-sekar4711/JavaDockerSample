pipeline {
    agent any


    triggers {
        pollSCM('*/1 * * * *')
    }

    environment {
        IMAGE_NAME = "basic-backend"
        // Add timestamp for unique tags
        DOCKER_TAG = "${BUILD_NUMBER}-${GIT_COMMIT.take(7)}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                // Display polling info
                echo "🚀 Polling triggered build #${BUILD_NUMBER}"
                echo "📦 Git Commit: ${GIT_COMMIT.take(7)}"
                sh 'echo "Repository checked out successfully"'
            }
        }

        stage('Build & Test') {
            agent {
                docker {
                    image 'maven:3.9.11-eclipse-temurin-17-alpine'
                    // Reuse node to keep workspace
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean test package'
                // Archive test results
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts 'target/*.jar'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build with unique tag and latest
                    sh "docker build -t ${IMAGE_NAME}:${DOCKER_TAG} ."
                    sh "docker tag ${IMAGE_NAME}:${DOCKER_TAG} ${IMAGE_NAME}:latest"

                    // List images to verify
                    sh 'docker images | grep basic-backend'
                }
            }
        }

        stage('Run Docker Compose') {
            steps {
                script {
                    sh '''
                        echo "🛑 Stopping existing containers..."
                        docker-compose down || echo "No containers to stop"

                        echo "🚀 Starting new deployment..."
                        docker-compose up -d --build

                        # Wait for services to start
                        sleep 30

                        echo "📊 Checking running services..."
                        docker-compose ps

                        # Health check
                        echo "🏥 Performing health check..."
                        curl -f http://localhost:8080/actuator/health || echo "⚠️  Health check failed or endpoint not ready"
                    '''
                }
            }
        }

        stage('Cleanup') {
            steps {
                sh '''
                    echo "🧹 Cleaning up old images..."
                    # Remove unused images (keep last 5)
                    docker images -f "dangling=true" -q | xargs -r docker rmi

                    # Remove old containers
                    docker ps -a -q --filter "status=exited" | xargs -r docker rm

                    echo "Cleanup complete!"
                '''
            }
        }
    }

    post {
        always {
            echo "🏁 Pipeline ${currentBuild.result ?: 'SUCCESS'} - Build #${BUILD_NUMBER}"

            // Clean workspace (optional)
            cleanWs()
        }
        success {
            echo '✅ Build, test, and deployment succeeded!'

            // Optional: Add notifications here
            // emailext to: 'team@company.com', subject: "Build Success", body: "Pipeline ${BUILD_NUMBER} passed"
        }
        failure {
            echo '❌ Something went wrong! Check the logs above.'

            // Archive logs on failure
            archiveArtifacts '**/target/*.log'
        }
        unstable {
            echo '⚠️  Build is unstable (tests failed but build completed)'
        }
    }
}