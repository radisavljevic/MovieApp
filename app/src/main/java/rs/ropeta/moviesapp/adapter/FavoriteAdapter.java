package rs.ropeta.moviesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import rs.ropeta.moviesapp.MovieDetailsActivity;
import rs.ropeta.moviesapp.R;
import rs.ropeta.moviesapp.model.Movie;
import rs.ropeta.moviesapp.model.MovieDetails;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {

    private List<MovieDetails> movieList;
    private Context context;

    public FavoriteAdapter(List<MovieDetails> listaFilmova, Context context) {
        this.movieList = listaFilmova;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_fav, parent, false);

        return new FavoriteAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.nazivFilma.setText(movieList.get(position).getTitle() != null ? movieList.get(position).getTitle().trim() : "");
        loadImageView(holder.wholeView.getContext(), holder.imageView, "https://image.tmdb.org/t/p/original" + movieList.get(position).getPoster_path());

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

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView nazivFilma;
        ImageView imageView;
        ImageButton button;
        private View wholeView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            this.wholeView = itemView;

            nazivFilma = (TextView) itemView.findViewById(R.id.nazivFilma_fav);
            imageView = itemView.findViewById(R.id.item_image_fav);
            button = itemView.findViewById(R.id.delete_btn);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    movieList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemChanged(getAdapterPosition(), movieList.size());

                }
            });

        }


    }

}
