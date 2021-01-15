import com.anaplan.buildtools.jenkins_pipelines.ContainerTemplates
import com.anaplan.buildtools.jenkins_pipelines.DefaultConfig

@Library('Anaplan_Pipeline')

def BUILD_LABEL = "overture.${UUID.randomUUID().toString()}"


pipeline {
    agent {
        kubernetes {
            label BUILD_LABEL
            yaml pod([ContainerTemplates.maven([:])])
        }
    }

    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(daysToKeepStr: '60'))
        timeout(time: 30, unit: 'MINUTES')
    }

    parameters {
        string(name: 'version', defaultValue: '')
    }

    stages {
        stage('Update versions') {
            steps {
                script {
                    container('maven') {
                      sh "mvn --batch-mode versions:set -DnewVersion=${params.version}"
                    }
                }
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    container('maven') {
                      sh "mvn --batch-mode package"
                    }
                }
            }
        }

        stage('Publish') {
            steps {
                container('maven') {
                    // Deploy the maven artifacts to Artifactory
                    withCredentials([usernamePassword(
                            credentialsId: DefaultConfig.ARTIFACTORY_UNSTABLE_CREDENTIAL_ID,
                            passwordVariable: 'ARTIFACTORY_PASSWORD',
                            usernameVariable: 'ARTIFACTORY_USERNAME'
                    )]) {
                        sh "./createSettingsXml" 
                        sh "mvn --batch-mode deploy -DskipTests -Ddeploy.pwd=\"$ARTIFACTORY_PASSWORD\""
                    }
                }
            }
        }
    }
}

