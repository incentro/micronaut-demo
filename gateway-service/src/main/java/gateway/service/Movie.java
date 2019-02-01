package gateway.service;

public class Movie {
    String imdbId;

    boolean inCollection;

    public Movie() {
    }

    public Movie(String imdbId, boolean inCollection) {
        this.imdbId = imdbId;
        this.inCollection = inCollection;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public boolean isInCollection() {
        return inCollection;
    }

}
