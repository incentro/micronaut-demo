# movie-list-service-2
Movie list service

Requires MongoDB docker container to be running on localhost (this can be changed in application.yml).

New users are created by POSTing to http://localhost:8082/api/user in the following format:

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
