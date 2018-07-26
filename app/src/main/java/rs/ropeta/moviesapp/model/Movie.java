package rs.ropeta.moviesapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Movie {

    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("genre_ids")
    int[] genreIds;
    @SerializedName("id")
    int id;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("original_language")
    String originalLanguage;
    @SerializedName("title")
    String title;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("vote_count")
    int voteCount;
    @SerializedName("video")
    String video;
    @SerializedName("vote_average")
    float voteAverage;


    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

//    @Override
//    public String toString() {
//        return "Movie{" +
//                "posterPath='" + posterPath + '\'' +
//                ", adult=" + adult +
//                ", overview='" + overview + '\'' +
//                ", releaseDate='" + releaseDate + '\'' +
//                ", genreIds=" + Arrays.toString(genreIds) +
//                ", id=" + id +
//                ", originalTitle='" + originalTitle + '\'' +
//                ", originalLanguage='" + originalLanguage + '\'' +
//                ", title='" + title + '\'' +
//                ", backdropPath='" + backdropPath + '\'' +
//                ", popularity=" + popularity +
//                ", voteCount=" + voteCount +
//                ", video='" + video + '\'' +
//                ", voteAverage=" + voteAverage +
//                '}';
//    }
    @Override
    public String toString() {
        return "Movie: " +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", overview='" + overview + '\'' +
                ", voteAverage=" + voteAverage + "\n";
    }
}
