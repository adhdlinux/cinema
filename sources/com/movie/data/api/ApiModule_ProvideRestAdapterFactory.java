package com.movie.data.api;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class ApiModule_ProvideRestAdapterFactory implements Provider {
    public static Retrofit a(ApiModule apiModule, OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit) Preconditions.d(apiModule.g(okHttpClient, gson));
    }
}
