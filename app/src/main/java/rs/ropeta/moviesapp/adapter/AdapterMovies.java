package rs.ropeta.moviesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import rs.ropeta.moviesapp.MovieDetailsActivity;
import rs.ropeta.moviesapp.R;
import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.MovieDetails;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.MyViewHolder> {

    private List<Movie> movieList;
    private Context context;

    public AdapterMovies(List<Movie> listaFilmova, Context context) {
        this.movieList = listaFilmova;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //((MyViewHolder) holder).setMovie(data);

        holder.nazivFilma.setText(movieList.get(position).getOriginalTitle() != null ? movieList.get(position).getOriginalTitle().trim() : "");
        holder.zanrFilma.setText(String.valueOf(movieList.get(position).getId()));
        holder.rejting.setText(String.valueOf(movieList.get(position).getVoteAverage()));
        loadImageView(holder.wholeView.getContext(), holder.imageView, "https://image.tmdb.org/t/p/original" + movieList.get(position).getPosterPath());


    }

    private void loadImageView(Context context, ImageView image, String imgUrl) {
        if (imgUrl != null && !imgUrl.isEmpty()) {
            Glide.with(context)
                    .load(imgUrl)
                    .fitCenter()
                    .placeholder(R.drawable.place_holder)
                    .crossFade()
                    .into(image);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nazivFilma, zanrFilma, rejting;
        ImageView imageView;
        Movie movie;
        private View wholeView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            this.wholeView = itemView;
            itemView.setOnClickListener(this);

            nazivFilma = (TextView) itemView.findViewById(R.id.nazivFilma);
            zanrFilma = (TextView) itemView.findViewById(R.id.zanrFilma);
            rejting = itemView.findViewById(R.id.rejtingFilma);
            imageView = itemView.findViewById(R.id.item_image);

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("id", movieList.get(getAdapterPosition()).getId());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
//        public void setMovie(Movie movie){
//            this.movie = movie;
//            nazivFilma.setText(movie.getOriginalTitle());
//            zanrFilma.setText(String.valueOf(movie.getGenreIds()));
//            loadImage(wholeView.getContext(), imageView, movie.getPosterPath());
//
//        }
//
//        private void loadImage(Context context, ImageView image, String imgUrl) {
//
//            if (imgUrl != null && !imgUrl.isEmpty()) {
//                Glide.with(context)
//                        .load(imgUrl)
//                        .fitCenter()
//                        .placeholder(R.drawable.place_holder)
//                        .crossFade()
//                        .into(image);
//            }
//
//
//        }
    }

}
