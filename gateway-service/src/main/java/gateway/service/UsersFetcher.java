package gateway.service;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.reactivex.Flowable;

public interface UsersFetcher {
    HttpResponse sendUser(String body);

    Flowable<Movie> fetchMovieList(String userName);
}
