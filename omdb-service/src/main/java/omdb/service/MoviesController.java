package omdb.service;

import com.google.gson.*;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/api")
public class MoviesController {

    private Gson gson = new Gson();

    private final MoviesClient moviesSearcher;

    public MoviesController(MoviesClient moviesSearcher) {
        this.moviesSearcher = moviesSearcher;
    }

    @Get("/movies/{keyword}")
    List<Movie> getByKeywords(String keyword) {
        return (gson.fromJson(moviesSearcher.searchMovies(keyword), OmdbData.class)).Search;
    }

    @Get("/movie/{id}")
    Movie getById(String id) {
        return gson.fromJson(moviesSearcher.searchId(id), Movie.class);
    }
}
