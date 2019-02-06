<b>NOTICE:</b> If you are aiming to test this application extensively, please acquire your own personal OMDB key at http://www.omdbapi.com and add it in the application.yml file of the omdb-service application.

The goal of this microservice application is to be able to create user owned lists of movies. The persistance service saves a user with the list of movies consisting of an IMDB id and an "is owned" flag per movie. The output of this list is enriched with IMDB movie data from omdbapi.com.

These microservices require a Consul and MongoDB docker container to be running. Services look for MongoDB and Consul on their default ports and localhost by default, this can be changed in the application.yml files for each service. You would want to do this if you are running the microservices in containers as well. In this case you will want to give static ip addresses to your Consul and MongoDB containers, and configure your microservices application.yml files to the corresponding ip addresses. No configuration is needed to connect the microservices, this is all managed by Consul. 


New users are created by POSTing to http://localhost:8080/api/user (gateway address) in the following format:

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

User information is retrieved with GET http://localhost:8080/api/user/{username} 

---------

This demonstration is based on a Micronaut microservices tutorial by Sergio del Amo Caballero from infoq.com:

https://www.infoq.com/articles/micronaut-tutorial-microservices-jvm

The follow-up tutorial is aimed at the use of tracing (monitoring) and security measures:

https://www.infoq.com/articles/micronaut-tracing-security-serverless

This part of the infoq tutorial is not yet part of the demonstration. Please note: Micronaut provides /info, /monitor, /health etc. endpoints to monitor your services.
