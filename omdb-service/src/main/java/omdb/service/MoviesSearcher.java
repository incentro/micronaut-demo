package omdb.service;

public interface MoviesSearcher {
    String searchMovies(String keyword);
    String searchId(String id);
}
