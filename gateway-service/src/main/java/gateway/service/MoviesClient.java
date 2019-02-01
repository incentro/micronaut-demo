package gateway.service;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Client("omdb-service")

@Requires(notEnv = Environment.TEST)
public interface MoviesClient extends MoviesFetcher{

    @Override @Get("/api/movies/{keyword}")
    Flowable<OmdbMovie> fetchMovies(String keyword);

    @Override @Get("/api/movie/{imdbId}")
    Maybe<OmdbMovie> fetchMovie(String imdbId);

}
