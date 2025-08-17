package com.movie.data.api.tmdb;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class TMDBModule_ProvideGsonFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final TMDBModule f31915a;

    public TMDBModule_ProvideGsonFactory(TMDBModule tMDBModule) {
        this.f31915a = tMDBModule;
    }

    public static TMDBModule_ProvideGsonFactory a(TMDBModule tMDBModule) {
        return new TMDBModule_ProvideGsonFactory(tMDBModule);
    }

    public static Gson c(TMDBModule tMDBModule) {
        return (Gson) Preconditions.d(tMDBModule.c());
    }

    /* renamed from: b */
    public Gson get() {
        return c(this.f31915a);
    }
}
