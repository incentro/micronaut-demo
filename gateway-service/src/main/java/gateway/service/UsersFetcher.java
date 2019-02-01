package gateway.service;

import io.reactivex.Flowable;

public interface UsersFetcher {
    Flowable<Movie> fetchMovieList(String userName);
}
