package com.uwetrottmann.thetvdb.services;

import com.uwetrottmann.thetvdb.entities.SearchParamsResponse;
import com.uwetrottmann.thetvdb.entities.SeriesResultsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface TheTvdbSearch {
    @GET("search/series/params")
    Call<SearchParamsResponse> params();

    @GET("search/series")
    Call<SeriesResultsResponse> series(@Query("name") String str, @Query("imdbId") String str2, @Query("zap2itId") String str3, @Query("slug") String str4, @Header("Accept-Language") String str5);
}
