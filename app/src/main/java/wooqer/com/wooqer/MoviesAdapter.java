package wooqer.com.wooqer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import wooqer.com.wooqer.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);

        }
    }

    public MoviesAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}