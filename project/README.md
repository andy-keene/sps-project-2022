# Dev Instructions

This directory (`/project`) will contain all code for our team project.

1. Login to [Google Cloud Shell](https://ssh.cloud.google.com/cloudshell/editor)
1. Clone this repo 
    ```
    git clone https://github.com/andy-keene/sps-project-2022.git
    ```
1. Switch to your personal development branch
    ```
    git branch akeene-dev
    ```
1. Update the `pom.xml` to use to your personal cloud project ID[^1] during development. 
1. Deploy the project from `~/sps-project-2022/project` run 
    ```
    mvn package appengine:deploy
    ```

You may find it helpful to revisit [walthroughs](https://github.com/google/software-product-sprint) for some of the earlier projects

[^1]: We also have a team project, ID `summer22-sps-33`, that we can use to host various dev milestones. Each team member will have the permissionsin required to deploy via App Engine.