package movie.list.service;

import com.google.gson.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import org.bson.Document;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/api")
public class ListController {

    Gson gson = new Gson();

    @Inject
    private DbConn dbConn;

    @Post("/user")
        public void postUser(@Body String body) {

        PostUserData userData = gson.fromJson(body, PostUserData.class);

        String userName = userData.userName;


        Document doc = new Document("userName", userName);

        if(userData.movies != null) {

            List<BasicDBObject> moviesDocList = userData.movies.stream().map(m -> {
                BasicDBObject dbMovie = new BasicDBObject();
                dbMovie.append("imdbId", m.getImdbId());
                dbMovie.append("inCollection", m.isInCollection());
                return dbMovie;
            }).collect(Collectors.toList());

            doc.append("movies", moviesDocList);
        }
        dbConn.collection.insertOne(doc);
    }

    @Get("/user/{userName}")
    public HttpResponse getUserMovieList(String userName) {
        BasicDBObject findUser = new BasicDBObject();
        findUser.put("userName", userName);
        FindIterable<Document> userList = dbConn.collection.find(findUser);
        Document doc = userList.first();

        if(doc == null) {
            return HttpResponse.notFound();
        }

        List<Movie> movieList = ((List<Document>)doc.get("movies")).stream()
                .map(d -> new Movie(d.getString("imdbId"), (Boolean) d.get("inCollection")))
                .collect(Collectors.toList());

        return HttpResponse.ok(movieList);
    }

}
