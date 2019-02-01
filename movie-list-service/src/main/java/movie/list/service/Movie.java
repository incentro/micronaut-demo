package movie.list.service;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private String imdbId;
    @SerializedName("inCollection")
    private boolean isInCollection;

    public Movie(String imdbId, boolean isInCollection) {
        this.imdbId = imdbId;
        this.isInCollection = isInCollection;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public boolean isInCollection() {
        return isInCollection;
    }

}
