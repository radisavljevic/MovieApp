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
import android.widget.Button;
import android.widget.EditText;
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
public class SearchFragment extends Fragment {

    private String API_KEY = "c22d755514350d9836b3f9b173b3d763";
    private ApiInterface apiInterface;
    private AdapterMovies adapterMovies;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context con;
    private String text;
    private Button buttonFindMovies;
    private EditText editTextMovies;

    public SearchFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_search, container, false);

        buttonFindMovies = (Button)view.findViewById(R.id.find_btn) ;
        editTextMovies = view.findViewById(R.id.edit_text_find_movies_frag);

        recyclerView = view.findViewById(R.id.recyclerviewsearch);
        layoutManager = new LinearLayoutManager(con);
        recyclerView.setLayoutManager(layoutManager);


        buttonFindMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = editTextMovies.getText().toString();

                apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<ResponseMovie> call = apiInterface.dajFiltriraneFilmove(API_KEY, text);
                call.enqueue(new Callback<ResponseMovie>() {
                    @Override
                    public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {

                        if(response.isSuccessful()){

                            ResponseMovie responseMovie = response.body();
                            if(responseMovie != null){
                                Log.e("RESPONSE_SER!!!!! : ", responseMovie.toString());

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

            }
        });




        return view;
    }

}
