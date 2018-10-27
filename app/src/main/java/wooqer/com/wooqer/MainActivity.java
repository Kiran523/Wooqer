package wooqer.com.wooqer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wooqer.com.wooqer.model.Movie;
import wooqer.com.wooqer.model.MoviesResponse;
import wooqer.com.wooqer.model.MoviesSearchResponse;
import wooqer.com.wooqer.network.ApiClient;
import wooqer.com.wooqer.network.ApiInterface;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final static String API_KEY = "3f869e81c300cd939e9602d34f616ee8";
    SearchView myFilter_ads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        myFilter_ads= (SearchView) findViewById(R.id.filter_ads_txt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        getMovieList(recyclerView, apiService);
        myFilter_ads.setIconifiedByDefault(false);
        myFilter_ads.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() >= 3) {
                    getMovieList(recyclerView, apiService);
                }else {
                    getMovieSearch(recyclerView, apiService,s);
                }
                return true;
            }
        });

    }

    private void getMovieList(final RecyclerView recyclerView, ApiInterface apiService) {
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
    private void getMovieSearch(final RecyclerView recyclerView, ApiInterface apiService,String msearch) {
        Call<MoviesSearchResponse> call = apiService.getMovieSearch(msearch,API_KEY);
        call.enqueue(new Callback<MoviesSearchResponse>() {
            @Override
            public void onResponse(Call<MoviesSearchResponse> call, Response<MoviesSearchResponse> response) {
                response.body();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesSearchResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

}
