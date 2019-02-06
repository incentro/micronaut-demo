package gateway.service;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Controller("/api")
public class UsersController {

    private final UsersFetcher usersFetcher;

    private final MoviesFetcher moviesFetcher;

    public UsersController(UsersFetcher usersFetcher, MoviesFetcher moviesFetcher) {
        this.usersFetcher = usersFetcher;
        this.moviesFetcher = moviesFetcher;
    }

    @Post("/user")
    HttpResponse postUser(@Body String body) {
        return usersFetcher.sendUser(body);
    }

    @Get("/movie/{imdbId}")
    Maybe<OmdbMovie> getMovieFromId(String imdbId) {
        return moviesFetcher.fetchMovie(imdbId);
    }

    @Get("/movies/{keyword}")
    Flowable<OmdbMovie> getMoviesFromKeyword(String keyword) {
        return moviesFetcher.fetchMovies(keyword);
    }


    @Get("/user/{userName}")
    Flowable<OmdbMovie> getMovieList(String userName) {
        return usersFetcher.fetchMovieList(userName)
                .flatMapMaybe(m -> moviesFetcher.fetchMovie(m.getImdbId())
                        .map(omdbMovie -> { omdbMovie.setInCollection(m.isInCollection());
                        return omdbMovie;}
                        )
                );
    }


}
