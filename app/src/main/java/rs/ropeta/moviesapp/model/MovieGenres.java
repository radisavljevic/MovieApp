package rs.ropeta.moviesapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieGenres {

    @SerializedName("genres")
    private List<Genres> genres;

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "MovieGenres{" +
                "genres=" + genres +
                '}';
    }
}
