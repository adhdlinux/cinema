package com.movie.data.api.tmdb;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class TMDBModule_ProvideTMDBApiFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final TMDBModule f31921a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Retrofit> f31922b;

    public TMDBModule_ProvideTMDBApiFactory(TMDBModule tMDBModule, Provider<Retrofit> provider) {
        this.f31921a = tMDBModule;
        this.f31922b = provider;
    }

    public static TMDBModule_ProvideTMDBApiFactory a(TMDBModule tMDBModule, Provider<Retrofit> provider) {
        return new TMDBModule_ProvideTMDBApiFactory(tMDBModule, provider);
    }

    public static TMDBApi c(TMDBModule tMDBModule, Retrofit retrofit) {
        return (TMDBApi) Preconditions.d(tMDBModule.f(retrofit));
    }

    /* renamed from: b */
    public TMDBApi get() {
        return c(this.f31921a, this.f31922b.get());
    }
}
