If you are aiming to test this application extensively, please acquire your own personal OMDB key at http://omdbapi.com and add it in the application.yml file of the omdb-service application.

This demonstration is based on a Micronaut microservices tutorial by Sergio del Amo Caballero from infoq.com:

https://www.infoq.com/articles/micronaut-tutorial-microservices-jvm

The follow-up tutorial is aimed at the use of tracing (monitoring) and security measures:

https://www.infoq.com/articles/micronaut-tracing-security-serverless

This part of the infoq tutorial is not yet part of the demonstration.

These microservices require a Consul and MongoDB docker container to be running. Services look for MongoDB and Consul on their default ports and localhost by default, this can be changed in the application.yml files for each service. You would want to do this if you are running the microservices in containers as well. In this case you will want to give static ip addresses to your Consul and MongoDB containers, and configure your microservices application.yml files to the corresponding ip addresses. No configuration is needed to connect the microservices, this is all managed by Consul. 


New users are created by POSTing to http://localhost/api/user (gateway address) in the following format:

```
{ "userName" : "edwin", 
	"movies" : [ 
		{
			"imdbId" : "tt1285016",
			"inCollection": "true"
		}, {
			"imdbId" : "tt0100502",
			"inCollection" : "false"
		} ]
}
```

User information is retrieved with GET http://localhost/api/user/{username} 
