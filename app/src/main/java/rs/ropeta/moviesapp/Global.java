package rs.ropeta.moviesapp;

import java.util.ArrayList;

import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.MovieDetails;

public class Global {

    public static ArrayList<MovieDetails> favoriteMovieList = new ArrayList<>();

    public static ArrayList<MovieDetails> getFavoriteMovieList() {
        return favoriteMovieList;
    }

    public static void setFavoriteMovieList(ArrayList<MovieDetails> favoriteMovieList) {
        Global.favoriteMovieList = favoriteMovieList;
    }
}
