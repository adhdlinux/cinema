package com.movie.data.api.tmdb;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class TMDBModule_ProvideOkHttpClientFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final TMDBModule f31916a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Application> f31917b;

    public TMDBModule_ProvideOkHttpClientFactory(TMDBModule tMDBModule, Provider<Application> provider) {
        this.f31916a = tMDBModule;
        this.f31917b = provider;
    }

    public static TMDBModule_ProvideOkHttpClientFactory a(TMDBModule tMDBModule, Provider<Application> provider) {
        return new TMDBModule_ProvideOkHttpClientFactory(tMDBModule, provider);
    }

    public static OkHttpClient c(TMDBModule tMDBModule, Application application) {
        return (OkHttpClient) Preconditions.d(tMDBModule.d(application));
    }

    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f31916a, this.f31917b.get());
    }
}
