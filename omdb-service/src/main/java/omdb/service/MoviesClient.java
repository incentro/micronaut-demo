package omdb.service;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("movies")
@Requires(notEnv = Environment.TEST)
public interface MoviesClient extends MoviesSearcher {

    final String apiKeyStr = "/?apikey=";
    final String searchQueryStr = "&s=";
    final String idQueryStr = "&i=";

    @Override
    @Get("${omdb.url}" + apiKeyStr + "${omdb.key}" + searchQueryStr + "{keyword}")
    OmdbData searchMovies(String keyword);

    @Override
    @Get("${omdb.url}" + apiKeyStr + "${omdb.key}" + idQueryStr + "{id}")
    Movie searchId(String id);
}