package rs.ropeta.moviesapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rs.ropeta.moviesapp.ApiClient;
import rs.ropeta.moviesapp.ApiInterface;
import rs.ropeta.moviesapp.R;
import rs.ropeta.moviesapp.adapter.AdapterMovies;
import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.ResponseMovie;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    private ApiInterface apiInterface;
    private AdapterMovies adapterMovies;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context con;

    public UpcomingFragment() {
        // Required empty public constructor
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        con = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_upcoming, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewupcoming);
        layoutManager = new LinearLayoutManager(con);
        recyclerView.setLayoutManager(layoutManager);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseMovie> call = apiInterface.dajUpcomingFilmove();
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {

                if(response.isSuccessful()){

                    ResponseMovie responseMovie = response.body();
                    if(responseMovie != null){
                        Log.e("RESPONSE!!!!! : ", responseMovie.toString());

                        List<Movie> movieList = responseMovie.getMovies();
                        adapterMovies = new AdapterMovies(movieList, con);
                        recyclerView.setAdapter(adapterMovies);

                    }

                }else {
                    Toast.makeText(con,
                            "Response is not success!", Toast.LENGTH_SHORT).show();
                    Log.e("Response is not succ ", response.message());
                }

            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

                Toast.makeText(con,
                        "Response is fail!", Toast.LENGTH_SHORT).show();
                Log.e("Response is fail ",t.getMessage());

            }
        });


        return view;
    }

}
