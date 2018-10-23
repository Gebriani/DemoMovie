package orcaella.com.demomovie.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import orcaella.com.demomovie.BuildConfig;
import orcaella.com.demomovie.model.GenreListReponse;
import orcaella.com.demomovie.model.MovieDetailModel;
import orcaella.com.demomovie.model.MovieListResponse;
import orcaella.com.demomovie.model.MovieModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RestClient {

    private static final int CONNECTION_TIME_OUT = 90;
    private static ApiService mApiService;

    public static ApiService getClient() {
        if (mApiService == null) {
            final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOSTNAME)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build();
            mApiService = retrofit.create(ApiService.class);
        }
        return mApiService;
    }


    public interface ApiService {
        @GET(ApiURL.LIST_MOVIE_POPULAR)
        Call<MovieListResponse> getPopularMovie(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiURL.LIST_MOVIE_TOP_RATED)
        Call<MovieListResponse> getTopRated(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiURL.LIST_MOVIE_UP_COMING)
        Call<MovieListResponse> getFavorite(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiURL.LIST_GENRE)
        Call<GenreListReponse> getGenreList(@Query("api_key") String api_key);

        @GET(ApiURL.LIST_MOVIE_DETAIL)
        Call<MovieDetailModel> getMovieDetail(@Path("movie_id") int movieID, @Query("api_key") String api_key);




    }

}
