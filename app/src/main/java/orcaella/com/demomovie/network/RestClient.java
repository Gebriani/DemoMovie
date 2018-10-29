package orcaella.com.demomovie.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import orcaella.com.demomovie.BuildConfig;
import orcaella.com.demomovie.model.GenreList;
import orcaella.com.demomovie.model.MovieDetail;
import orcaella.com.demomovie.model.MovieList;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
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
        @GET(ApiUrl.LIST_MOVIE_POPULAR)
        Call<MovieList> getPopularMovie(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiUrl.LIST_MOVIE_TOP_RATED)
        Call<MovieList> getTopRated(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiUrl.LIST_MOVIE_UP_COMING)
        Call<MovieList> getFavorite(@Query("api_key") String api_key, @Query("page") int page);

        @GET(ApiUrl.LIST_GENRE)
        Call<GenreList> getGenreList(@Query("api_key") String api_key);

        @GET(ApiUrl.LIST_MOVIE_DETAIL)
        Call<MovieDetail> getMovieDetail(@Path("movie_id") int movieID, @Query("api_key") String api_key);




    }

}
