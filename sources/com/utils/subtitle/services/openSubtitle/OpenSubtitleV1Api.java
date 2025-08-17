package com.utils.subtitle.services.openSubtitle;

import com.utils.subtitle.services.openSubtitle.models.BaseResponse;
import com.utils.subtitle.services.openSubtitle.models.DownloadRequest;
import com.utils.subtitle.services.openSubtitle.models.DownloadResponse;
import com.utils.subtitle.services.openSubtitle.models.LanguagesResponse;
import com.utils.subtitle.services.openSubtitle.models.LoginRequest;
import com.utils.subtitle.services.openSubtitle.models.LoginResponse;
import com.utils.subtitle.services.openSubtitle.models.Subtitles;
import com.utils.subtitle.services.openSubtitle.models.UserInfoResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OpenSubtitleV1Api {
    @POST("v1/download")
    @Headers({"Content-Type: application/json", "Accept: */*"})
    Call<DownloadResponse> download(@Body DownloadRequest downloadRequest);

    @GET("v1/infos/languages")
    Call<LanguagesResponse> getLanguages();

    @GET("v1/infos/user")
    Call<UserInfoResponse> getUsers();

    @POST("v1/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @DELETE("v1/logout")
    Call<BaseResponse> logout();

    @GET("v1/subtitles")
    Call<Subtitles> searchSubtitle(@Query("moviehash") String str, @Query("imdb_id") Integer num, @Query("tmdb_id") Integer num2, @Query("parent_imdb_id") Integer num3, @Query("parent_tmdb_id") Integer num4, @Query("season_number") Integer num5, @Query("episode_number") Integer num6, @Query("query") String str2, @Query("type") String str3, @Query("languages") String str4, @Query("year") Integer num7, @Query("page") int i2);
}
