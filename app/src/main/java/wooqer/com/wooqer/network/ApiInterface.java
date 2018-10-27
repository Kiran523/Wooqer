package wooqer.com.wooqer.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wooqer.com.wooqer.model.MoviesResponse;


public interface ApiInterface {
    @GET("list/509ec17b19c2950a0600050d")
    Call<MoviesResponse> getMoviesList(@Query("api_key") String apiKey);

}
