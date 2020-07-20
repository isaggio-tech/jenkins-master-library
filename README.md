# jenkins-master-library

# pipeline-library-demo

Demonstrates how to use a Shared Library in Jenkins pipelines. This repository defines a single function, `sayHello`, which will echo a greeting.

## Setup instructions

1. In Jenkins, go to Manage Jenkins &rarr; Configure System. Under _Global Pipeline Libraries_, add a library with the following settings:

    - Name: `pipeline-library-demo`
    - Default version: Specify a Git reference (branch or commit SHA), e.g. `master`
    - Retrieval method: _Modern SCM_
    - Select the _Git_ type
    - Project repository: `https://github.com/monodot/pipeline-library-demo.git`
    - Credentials: (leave blank)
    
    OR using JCasC,
    
    ```
     unclassified:
       globalLibraries:
         libraries:
           - name: "master-shared-lib"
             defaultVersion: "master"
             retriever:
               modernSCM:
                 scm:
                   git:
                     remote: "https://github.com/isaggio-tech/jenkins-master-library.git"
    ```                     

2. Then create a Jenkins job with the following pipeline (note that the underscore `_` is not a typo):

    ```
    @Library('master-shared-lib')_

    pipeline {
        agent { label 'python' }
        stages {
            stage('Shared Library Demo') {
                steps {
                    echo 'Testing the Shared Library'
                    helloWorld 'Hari !!!'   
                }
            }    
        }
    }
    ```

This will output the following from the build:

```
[Pipeline] stage
[Pipeline] { (Shared Library Demo)
[Pipeline] echo
Hello world
[Pipeline] echo
Hello, Hari.
[Pipeline] }
[Pipeline] // stage
[Pipeline] End of Pipeline
Finished: SUCCESS
```
