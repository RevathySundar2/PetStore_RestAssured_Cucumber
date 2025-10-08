pipeline
{
    agent any
    parameters
    {
       choice(name: 'ENV', choices:['qa','uat','prod'], description: 'Select Environment')
       choice(name:'TAGS', choices:['@smoketest', '@regression', '@smoke', '@SampleLearning'])
    }
    tools {
    maven 'Apache Maven 3.9.9'
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
                agent { docker { image 'maven:3.9.9-eclipse-temurin-17' } }
                echo "Performing test execution...."
                sh "mvn clean verify -P${params.ENV} -Dcucumber.filter.tags=${params.TAGS}"
            }

        }
    }
}
