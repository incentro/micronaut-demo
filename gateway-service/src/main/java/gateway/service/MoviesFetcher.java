package gateway.service;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public interface MoviesFetcher {
    Flowable<OmdbMovie> fetchMovies(String keyword);

    Maybe<OmdbMovie> fetchMovie(String imdbId);
}
