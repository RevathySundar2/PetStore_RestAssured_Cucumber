pipeline
{
    agent any
    stages
    {
        stage('Build')
        {
            steps
            {
                echo "Building the code......"
                bat "mvn clean"
            }
        }
        stage('Deploy')
        {
            steps
            {
                echo "Deploying the code......"
            }
        }
        stage('Test')
        {
            steps
            {
                echo "Performing test execution...."
                bat "mvn test"
                echo ".......Generating test reports......."
                bat "mvn verify"
            }

        }
}