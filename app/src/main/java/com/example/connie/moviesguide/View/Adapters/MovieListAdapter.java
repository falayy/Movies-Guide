package com.example.connie.moviesguide.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.connie.moviesguide.R;
import com.example.connie.moviesguide.View.fragments.MoviesFragment;
import com.example.connie.moviesguide.model.data.Movie;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private  Context context;
    private List<Movie> movie;
    private Fragment fragment;
    ImageView movieImageView;
    OnClickListener onClickListener;
    private String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original";



    public MovieListAdapter(Context context, OnClickListener onClickListener, List<Movie> movie, Fragment fragment){
        this.context = context;
        this.movie = movie;
        this.fragment = fragment;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_layout_item, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        if (movie != null){
            Movie currentMovies = movie.get(i);
            Glide.with(fragment).load(IMAGE_BASE_URL + currentMovies.getmImage()).into(movieImageView);
            String movieTitle = currentMovies.getmTitle();

            movieImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    }
            });
            movieViewHolder.movieTitleTextView.setText(movieTitle);
            }



    }

    @Override
    public int getItemCount() {
        if (movie == null){
            return  0;
        }else{
            return movie.size();
        }

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitleTextView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.grid_image_view);
            movieTitleTextView = itemView.findViewById(R.id.grid_text_view);
        }
    }

    public void setData(List<Movie> newMovie){
        this.movie = newMovie;
        notifyDataSetChanged();
    }

    public List<Movie> getData(){
        return movie;
    }


    public interface OnClickListener{
        void onClick(Movie movie);
    }


}
