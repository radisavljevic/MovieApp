package rs.ropeta.moviesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rs.ropeta.moviesapp.model.ConfigurationResponse;
import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.MovieDetails;
import rs.ropeta.moviesapp.model.MovieGenres;
import rs.ropeta.moviesapp.model.ResponseMovie;

public interface ApiInterface {

    String API_KEY = "?api_key=c22d755514350d9836b3f9b173b3d763";

    @GET("movie/latest?api_key=c22d755514350d9836b3f9b173b3d763&language=en-US")
    Call<Movie> getLatestMovies(@Path("sifra") String sifra);

    @GET("movie/popular" + API_KEY)
    Call<ResponseMovie> dajPopularneFilmove();

    @GET("movie/top_rated" + API_KEY)
    Call<ResponseMovie> dajTopRatedFilmove();

    @GET("movie/upcoming" + API_KEY)
    Call<ResponseMovie> dajUpcomingFilmove();

    @GET("configuration" + API_KEY)
    Call<ConfigurationResponse> configuration();

    @GET("genre/movie/list" + API_KEY)
    Call<MovieGenres> dajZanrove();

    @GET("movie/{id}" + API_KEY)
    Call<MovieDetails> dajFilmPodId(@Path("id") int id);

    @GET("movie/{id}/recommendations" + API_KEY)
    Call<ResponseMovie> dajRecommedentsFilmove(@Path("id") int id);


    @GET("search/movie")
    Call<ResponseMovie> dajFiltriraneFilmove(@Query("api_key") String apiKey, @Query("query") String query);

}
