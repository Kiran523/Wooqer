package wooqer.com.wooqer.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wooqer.com.wooqer.model.MoviesResponse;
import wooqer.com.wooqer.model.MoviesSearchResponse;
public interface ApiInterface {
    @GET("list/509ec17b19c2950a0600050d")
    Call<MoviesResponse> getMoviesList(@Query("api_key") String apiKey);
    @GET("search/movie/")
    Call<MoviesSearchResponse> getMovieSearch(@Query("query") String apiKey,@Query("api_key") String query);
}
