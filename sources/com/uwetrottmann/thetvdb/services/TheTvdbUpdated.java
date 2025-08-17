package com.uwetrottmann.thetvdb.services;

import com.uwetrottmann.thetvdb.entities.SeriesUpdatesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheTvdbUpdated {
    @GET("updated/query")
    Call<SeriesUpdatesResponse> seriesUpdates(@Query("fromTime") Long l2, @Query("toTime") Long l3);
}
