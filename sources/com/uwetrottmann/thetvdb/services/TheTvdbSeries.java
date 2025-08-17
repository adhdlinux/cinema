package com.uwetrottmann.thetvdb.services;

import com.uwetrottmann.thetvdb.entities.ActorsResponse;
import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import com.uwetrottmann.thetvdb.entities.EpisodesSummaryResponse;
import com.uwetrottmann.thetvdb.entities.SeriesImageQueryResultResponse;
import com.uwetrottmann.thetvdb.entities.SeriesImagesQueryParamResponse;
import com.uwetrottmann.thetvdb.entities.SeriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheTvdbSeries {
    @GET("series/{id}/actors")
    Call<ActorsResponse> actors(@Path("id") int i2);

    @GET("series/{id}/episodes")
    Call<EpisodesResponse> episodes(@Path("id") int i2, @Query("page") Integer num, @Header("Accept-Language") String str);

    @GET("series/{id}/episodes/query")
    Call<EpisodesResponse> episodesQuery(@Path("id") int i2, @Query("absoluteNumber") Integer num, @Query("airedSeason") Integer num2, @Query("airedEpisode") Integer num3, @Query("dvdSeason") Integer num4, @Query("dvdEpisode") Double d2, @Query("imdbId") String str, @Query("firstAired") String str2, @Query("page") Integer num5, @Header("Accept-Language") String str3);

    @GET("series/{id}/episodes/summary")
    Call<EpisodesSummaryResponse> episodesSummary(@Path("id") int i2);

    @GET("series/{id}/images/query")
    Call<SeriesImageQueryResultResponse> imagesQuery(@Path("id") int i2, @Query("keyType") String str, @Query("resolution") String str2, @Query("subKey") String str3, @Header("Accept-Language") String str4);

    @GET("series/{id}/images/query/params")
    Call<SeriesImagesQueryParamResponse> imagesQueryParams(@Path("id") int i2);

    @GET("series/{id}")
    Call<SeriesResponse> series(@Path("id") int i2, @Header("Accept-Language") String str);

    @HEAD("series/{id}")
    Call<Void> seriesHeader(@Path("id") int i2, @Header("Accept-Language") String str);
}
