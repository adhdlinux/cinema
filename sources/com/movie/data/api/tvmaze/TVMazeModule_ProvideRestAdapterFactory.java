package com.movie.data.api.tvmaze;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class TVMazeModule_ProvideRestAdapterFactory implements Provider {
    public static Retrofit a(TVMazeModule tVMazeModule, OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit) Preconditions.d(tVMazeModule.d(okHttpClient, gson));
    }
}
