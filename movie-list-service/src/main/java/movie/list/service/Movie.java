package movie.list.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Movie {
    private String imdbId;
    @JsonProperty("inCollection")
    private boolean isInCollection;

    @JsonCreator
    public Movie(@JsonProperty("imdbId") String imdbId, @JsonProperty("inCollection") boolean isInCollection) {
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
