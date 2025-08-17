package com.uwetrottmann.thetvdb.services;

import com.uwetrottmann.thetvdb.entities.LanguageResponse;
import com.uwetrottmann.thetvdb.entities.LanguagesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheTvdbLanguages {
    @GET("languages")
    Call<LanguagesResponse> allAvailable();

    @GET("languages/{id}")
    Call<LanguageResponse> languageDetails(@Path("id") int i2);
}
