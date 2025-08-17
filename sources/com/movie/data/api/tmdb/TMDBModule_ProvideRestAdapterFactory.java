package com.movie.data.api.tmdb;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class TMDBModule_ProvideRestAdapterFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final TMDBModule f31918a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f31919b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Gson> f31920c;

    public TMDBModule_ProvideRestAdapterFactory(TMDBModule tMDBModule, Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f31918a = tMDBModule;
        this.f31919b = provider;
        this.f31920c = provider2;
    }

    public static TMDBModule_ProvideRestAdapterFactory a(TMDBModule tMDBModule, Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new TMDBModule_ProvideRestAdapterFactory(tMDBModule, provider, provider2);
    }

    public static Retrofit c(TMDBModule tMDBModule, OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit) Preconditions.d(tMDBModule.e(okHttpClient, gson));
    }

    /* renamed from: b */
    public Retrofit get() {
        return c(this.f31918a, this.f31919b.get(), this.f31920c.get());
    }
}
