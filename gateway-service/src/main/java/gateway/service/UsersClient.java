package gateway.service;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("movie-list-service")

@Requires(notEnv = Environment.TEST)
public interface UsersClient extends UsersFetcher{

    @Override @Get("/api/user/{userName}")
    Flowable<Movie> fetchMovieList(String userName);
}
