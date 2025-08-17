package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.PlaybackResponse;
import com.uwetrottmann.trakt5.entities.ScrobbleProgress;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Scrobble {
    @POST("scrobble/pause")
    Call<PlaybackResponse> pauseWatching(@Body ScrobbleProgress scrobbleProgress);

    @POST("scrobble/start")
    Call<PlaybackResponse> startWatching(@Body ScrobbleProgress scrobbleProgress);

    @POST("scrobble/stop")
    Call<PlaybackResponse> stopWatching(@Body ScrobbleProgress scrobbleProgress);
}
