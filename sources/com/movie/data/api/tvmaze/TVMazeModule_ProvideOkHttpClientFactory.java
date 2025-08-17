package com.movie.data.api.tvmaze;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class TVMazeModule_ProvideOkHttpClientFactory implements Provider {
    public static OkHttpClient a(TVMazeModule tVMazeModule, Application application) {
        return (OkHttpClient) Preconditions.d(tVMazeModule.c(application));
    }
}
