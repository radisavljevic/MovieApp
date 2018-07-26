package rs.ropeta.moviesapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovie {

    @SerializedName("page")
    public int page;
    @SerializedName("total_results")
    int total_results;
    @SerializedName("total_pages")
    int total_pages;
    @SerializedName("results")
    public List<Movie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getMovies() {
        return results;
    }

    public void setMovies(List<Movie> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResponseMovie{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", Movies=" + results +
                '}';
    }
}
