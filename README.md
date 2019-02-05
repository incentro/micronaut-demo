These microservices require a Consul and MongoDB docker container to be running. Services look for MongoDB and Consul on their default ports and localhost by default, this can be changed in the application.yml files for each service. You would want to do this if you are running the microservices in containers as well. In this case you will want to give static ip address to your Consul and MongoDB containers, and configure your microservices application.yml files to the corresponding ip addresses. No configuration is needed to connect the microservices, this is all managed by Consul. 
