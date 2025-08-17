package com.movie.data.api.imdb;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class IMDBModule_ProvideRestAdapterFactory implements Provider {
    public static Retrofit a(IMDBModule iMDBModule, OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit) Preconditions.d(iMDBModule.e(okHttpClient, gson));
    }
}
