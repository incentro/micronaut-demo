package omdb.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;

@Controller("/api")
public class MoviesController {

    private final MoviesClient moviesSearcher;

    public MoviesController(MoviesClient moviesSearcher) {
        this.moviesSearcher = moviesSearcher;
    }

    @Get("/movies/{keyword}")
    List<Movie> getByKeywords(String keyword) {
        return moviesSearcher.searchMovies(keyword).getMovies();
    }

    @Get("/movie/{id}")
    Movie getById(String id) {
        return moviesSearcher.searchId(id);
    }
}
