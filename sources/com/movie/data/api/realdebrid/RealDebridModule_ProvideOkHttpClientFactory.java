package com.movie.data.api.realdebrid;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class RealDebridModule_ProvideOkHttpClientFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final RealDebridModule f31909a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Application> f31910b;

    public RealDebridModule_ProvideOkHttpClientFactory(RealDebridModule realDebridModule, Provider<Application> provider) {
        this.f31909a = realDebridModule;
        this.f31910b = provider;
    }

    public static RealDebridModule_ProvideOkHttpClientFactory a(RealDebridModule realDebridModule, Provider<Application> provider) {
        return new RealDebridModule_ProvideOkHttpClientFactory(realDebridModule, provider);
    }

    public static OkHttpClient c(RealDebridModule realDebridModule, Application application) {
        return (OkHttpClient) Preconditions.d(realDebridModule.c(application));
    }

    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f31909a, this.f31910b.get());
    }
}
