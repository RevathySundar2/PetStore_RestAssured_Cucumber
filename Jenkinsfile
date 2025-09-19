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
                bat "mvn clean test"
                echo ".......Generating test reports......."
                bat "mvn verify"
            }

        }
    }
}
