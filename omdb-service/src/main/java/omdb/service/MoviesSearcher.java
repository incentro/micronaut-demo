package omdb.service;

import io.reactivex.Single;

public interface MoviesSearcher {
    OmdbData searchMovies(String keyword);
    Movie searchId(String id);
}
