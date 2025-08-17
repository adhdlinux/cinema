package com.uwetrottmann.thetvdb.services;

import com.uwetrottmann.thetvdb.entities.LoginData;
import com.uwetrottmann.thetvdb.entities.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TheTvdbAuthentication {
    public static final String PATH_LOGIN = "login";

    @POST("login")
    Call<Token> login(@Body LoginData loginData);

    @GET("refresh_token")
    Call<Token> refreshToken();
}
