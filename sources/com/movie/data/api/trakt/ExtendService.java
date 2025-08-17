package com.movie.data.api.trakt;

import com.movie.data.model.trakt.AnticipatedMovie;
import com.movie.data.model.trakt.AnticipatedShow;
import com.movie.data.model.trakt.BoxOffice;
import com.movie.data.model.trakt.FeatureListResultItem;
import com.movie.data.model.trakt.ListItemItem;
import com.movie.data.model.trakt.MostWatchedAndCollectedMovie;
import com.movie.data.model.trakt.MostWatchedAndCollectedShow;
import com.movie.data.model.trakt.RecommendedMovie;
import com.movie.data.model.trakt.RecommendedShow;
import com.uwetrottmann.trakt5.entities.PlaybackResponse;
import com.uwetrottmann.trakt5.entities.SearchResult;
import com.uwetrottmann.trakt5.enums.Extended;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ExtendService {
    @GET("movies/anticipated")
    Call<List<AnticipatedMovie>> anticipatedMovies(@Query("page") int i2, @Query("limit") int i3);

    @GET("shows/anticipated")
    Call<List<AnticipatedShow>> anticipatedShows(@Query("page") int i2, @Query("limit") int i3);

    @GET("/movies/boxoffice")
    Call<List<BoxOffice>> boxOffice(@Query("page") int i2, @Query("limit") int i3);

    @GET("lists/{id}/items/movies,shows")
    Call<List<ListItemItem>> featureListItems(@Path("id") String str, @Query("page") int i2, @Query("limit") int i3);

    @GET("sync/playback/episodes")
    Call<List<PlaybackResponse>> getPlaybackEpisodes(@Query("start_at") String str, @Query("end_at") String str2);

    @GET("sync/playback/movies")
    Call<List<PlaybackResponse>> getPlaybackMovies(@Query("start_at") String str, @Query("end_at") String str2);

    @GET("movies/collected/period")
    Call<List<MostWatchedAndCollectedMovie>> mostCollectedMovie(@Query("page") int i2, @Query("limit") int i3);

    @GET("shows/collected/period")
    Call<List<MostWatchedAndCollectedShow>> mostCollectedShow(@Query("page") int i2, @Query("limit") int i3);

    @GET("movies/watched/period")
    Call<List<MostWatchedAndCollectedMovie>> mostWatchedMovie(@Query("page") int i2, @Query("limit") int i3);

    @GET("shows/watched/period")
    Call<List<MostWatchedAndCollectedShow>> mostWatchedShow(@Query("page") int i2, @Query("limit") int i3);

    @GET("lists/popular")
    Call<List<FeatureListResultItem>> popularFeatureList(@Query("page") int i2, @Query("limit") int i3);

    @GET("movies/recommended/period")
    Call<List<RecommendedMovie>> recommendedMovie(@Query("page") int i2, @Query("limit") int i3);

    @GET("shows/recommended/period")
    Call<List<RecommendedShow>> recommendedShow(@Query("page") int i2, @Query("limit") int i3);

    @GET("search/{type}")
    Call<List<SearchResult>> searchAll(@Path("type") String str, @Query("query") String str2, @Query("years") String str3, @Query("genres") String str4, @Query("languages") String str5, @Query("countries") String str6, @Query("runtimes") String str7, @Query("ratings") String str8, @Query("extended") Extended extended, @Query("page") Integer num, @Query("limit") Integer num2);

    @GET("lists/trending")
    Call<List<FeatureListResultItem>> trendingFeatureList(@Query("page") int i2, @Query("limit") int i3);
}
