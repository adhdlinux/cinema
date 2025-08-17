package com.movie.data.api.realdebrid;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class RealDebridModule_ProvideGsonFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final RealDebridModule f31908a;

    public RealDebridModule_ProvideGsonFactory(RealDebridModule realDebridModule) {
        this.f31908a = realDebridModule;
    }

    public static RealDebridModule_ProvideGsonFactory a(RealDebridModule realDebridModule) {
        return new RealDebridModule_ProvideGsonFactory(realDebridModule);
    }

    public static Gson c(RealDebridModule realDebridModule) {
        return (Gson) Preconditions.d(realDebridModule.b());
    }

    /* renamed from: b */
    public Gson get() {
        return c(this.f31908a);
    }
}
