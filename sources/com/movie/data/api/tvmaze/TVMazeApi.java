package com.movie.data.api.tvmaze;

import com.movie.data.model.tvmaze.MazeTVEpisodeItem;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TVMazeApi {
    @GET("schedule")
    Observable<List<MazeTVEpisodeItem>> getCalendar(@Query("date") String str);
}
