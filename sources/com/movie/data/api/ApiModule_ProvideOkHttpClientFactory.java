package com.movie.data.api;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideOkHttpClientFactory implements Provider {
    public static OkHttpClient a(ApiModule apiModule, Application application) {
        return (OkHttpClient) Preconditions.d(apiModule.f(application));
    }
}
