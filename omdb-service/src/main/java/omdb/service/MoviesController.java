package omdb.service;

import com.google.gson.*;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api")
public class MoviesController {

    private Gson gson = new Gson();

    private final MoviesClient moviesSearcher;

    public MoviesController(MoviesClient moviesSearcher) {
        this.moviesSearcher = moviesSearcher;
    }

    @Get("/movies/{keyword}")
    Movie[] getByKeywords(String keyword) {
        return gson.fromJson(
                gson.fromJson(moviesSearcher.searchMovies(keyword), JsonObject.class)
                        .get("Search").toString(), Movie[].class);
    }

    @Get("/movie/{id}")
    Movie getById(String id) {
        return gson.fromJson(moviesSearcher.searchId(id), Movie.class);
    }
}
