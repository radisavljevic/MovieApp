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

import java.util.List;

import rs.ropeta.moviesapp.Global;
import rs.ropeta.moviesapp.R;
import rs.ropeta.moviesapp.adapter.FavoriteAdapter;
import rs.ropeta.moviesapp.model.MovieDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private List<MovieDetails> movieDetailsList;
    private Context con;
    private FavoriteAdapter favoriteAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        con = context;
    }

    @Override
    public void onStart() {
        super.onStart();

        movieDetailsList = Global.getFavoriteMovieList();

        Log.e("movieDetailsList", Global.getFavoriteMovieList().toString());

        favoriteAdapter = new FavoriteAdapter(movieDetailsList, con);
        recyclerView.setAdapter(favoriteAdapter);
        favoriteAdapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewfavorite);
        layoutManager = new LinearLayoutManager(con);
        recyclerView.setLayoutManager(layoutManager);





        return view;
    }

}
