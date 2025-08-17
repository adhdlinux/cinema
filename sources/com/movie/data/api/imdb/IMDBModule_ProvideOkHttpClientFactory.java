package com.movie.data.api.imdb;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class IMDBModule_ProvideOkHttpClientFactory implements Provider {
    public static OkHttpClient a(IMDBModule iMDBModule, Application application) {
        return (OkHttpClient) Preconditions.d(iMDBModule.d(application));
    }
}
