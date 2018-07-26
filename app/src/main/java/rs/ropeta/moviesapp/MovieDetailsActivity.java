package rs.ropeta.moviesapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.MovieDetails;
import rs.ropeta.moviesapp.model.ResponseMovie;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView naziv, release, overview, listOfRecommend;
    Button rateButton;
    private ApiInterface apiInterface;
    private MovieDetails movieDetails;
    private ResponseMovie responseMovie;
    private String baseImgUrl = "https://image.tmdb.org/t/p/original";
    private Context context;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        int id = getIntent().getIntExtra("id", 0);
        //Toast.makeText(this, "ID = " + String.valueOf(id), Toast.LENGTH_SHORT).show();

        imageView = (ImageView)findViewById(R.id.item_image_details);
        naziv = (TextView)findViewById(R.id.nazivFilmaDetails);
        release = (TextView)findViewById(R.id.releaseFilma);
        overview = (TextView)findViewById(R.id.overviewFilma);
        listOfRecommend = (TextView)findViewById(R.id.listOfRecommFilma);
        rateButton = (Button)findViewById(R.id.addToFav);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(MovieDetails movie : Global.favoriteMovieList){
                    if(movie.getId() == movieDetails.getId()){
                        movieDetails.setInFav(true);
                    }
                }

                if(movieDetails.getInFav()){
                    Toast.makeText(getApplicationContext(),
                            "Movie is already in favorites!", Toast.LENGTH_SHORT).show();
                }else{
                    movieDetails.setInFav(true);
                    Global.favoriteMovieList.add(movieDetails);
                    Toast.makeText(getApplicationContext(),
                            "Movie send to favorites!", Toast.LENGTH_SHORT).show();
                }


            }
        });


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading…");
        pDialog.show();
        //loadImageView(holder.wholeView.getContext(), holder.imageView,  + movieList.get(position).getPosterPath());
        ucitaj(id);

    }

    private void ucitaj(final int id) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieDetails> call = apiInterface.dajFilmPodId(id);
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                if(response.isSuccessful()){

                    movieDetails = response.body();

                    String imgUrl = baseImgUrl + movieDetails.getPoster_path();


                        if (imgUrl != null && !imgUrl.isEmpty()) {
                            Glide.with(getBaseContext())
                                    .load(imgUrl)
                                    .fitCenter()
                                    .placeholder(R.drawable.place_holder)
                                    .crossFade()
                                    .into(imageView);
                        }

                    naziv.setText("Title: " + movieDetails.getTitle());
                    release.setText("Release date: " + movieDetails.getRelease_date());
                    overview.setText("Details: " + movieDetails.getOverview());

                    ucitajListOfRecommend(id);

                }else {
                    Log.e("Response is fail ", "FAIL!!!");
                    pDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

                Log.e("Response is fail ",t.getMessage());
                pDialog.dismiss();
            }
        });


    }

    private void ucitajListOfRecommend(int id) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseMovie> call = apiInterface.dajRecommedentsFilmove(id);
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {

                if(response.isSuccessful()){

                     responseMovie = response.body();
                    if(responseMovie != null){

                        List<Movie> movieList = responseMovie.getMovies();
                        StringBuilder sb = new StringBuilder();
                        for(Movie movie : movieList){
                            sb.append(movie.getTitle() + ", " + movie.getVoteAverage() + "\n");

                        }

                        listOfRecommend.setText("List of recommendations: " + "\n" + sb.toString());
                        pDialog.dismiss();

                    }else {
                        Log.e("Response is not succ ", response.message());
                        pDialog.dismiss();
                    }

                }else {
                    Log.e("Response is fail ", "FAIL!!!");
                    pDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

                Log.e("Response is fail ", "FAIL!!!");
                pDialog.dismiss();

            }
        });

    }
}
