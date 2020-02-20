# Cloud Foundry - Spring - Demo
React and Spring-boot based employee application with CI/CD on concourse and deployed onto Pivotal Cloud Foundry

#### Cloud Foundry deployment
In order to deploy your spring application onto CF, on should have access to PWS: https://console.run.pivotal.io/  <br />
1. Run the below command which would refer to the manifest.yml file to push the application to CF <br />
cf push 
2. To restage the application after any changes, use the below command <br />
cf restage <APP_NAME>

#### Concourse pipeline
We have used Concourse to implement CI/CD. Below are the steps that you need to carry out in order to deploy this on concourse. 
 
1. Download the docker file to start the concourse UI on local machine <br />
wget https://raw.githubusercontent.com/starkandwayne/concourse-tutorial/master/docker-compose.yml <br />
docker-compose up -d

2. Login to: http://127.0.0.1:8080/

3. Download the fly CLI as displayed on the UI

4. Give access to fly so that we can run fly commands <br />
sudo mv ~/Downloads/fly /usr/local/bin <br />
sudo chmod 0755 /usr/local/bin/fly

5. login to local concourse using the below fly command with task tutorial <br />
fly --target tutorial login --concourse-url http://127.0.0.1:8080 -u <user> -p <pass> <br />
fly --target tutorial sync

6. Create pipeline using the below command <br /> 
fly -t tutorial set-pipeline -c pipeline.yml -p pwd-spring-boot-demo -l credential.yml