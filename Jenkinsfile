pipeline
{
    agent any
    parameters
    {
       choice(name: 'ENV', choices:['qa','uat','prod'], description: 'Select Environment')
    }
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
                sh "mvn clean verify -P${params.ENV}"
            }

        }
    }
}
