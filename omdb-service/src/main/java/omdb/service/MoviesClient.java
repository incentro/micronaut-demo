package omdb.service;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("movies")
@Requires(notEnv = Environment.TEST)
public interface MoviesClient extends MoviesSearcher {

    @Override
    @Get("http://www.omdbapi.com/?apikey=${omdb.key}&s={keyword}")
    String searchMovies(String keyword);

    @Override
    @Get("http://www.omdbapi.com/?apikey=${omdb.key}&i={id}")
    String searchId(String id);
}