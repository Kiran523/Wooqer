package wooqer.com.wooqer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wooqer.com.wooqer.model.Movie;
import wooqer.com.wooqer.model.MoviesResponse;
import wooqer.com.wooqer.network.ApiClient;
import wooqer.com.wooqer.network.ApiInterface;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final static String API_KEY = "3f869e81c300cd939e9602d34f616ee8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getMoviesList(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getItems();
                recyclerView.setAdapter(new MoviesAdapter(movies, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    }
