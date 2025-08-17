package com.movie.data.api.imdb;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMDBApi {
    @GET("title/{id}")
    Observable<ResponseBody> search(@Path("id") String str);
}
