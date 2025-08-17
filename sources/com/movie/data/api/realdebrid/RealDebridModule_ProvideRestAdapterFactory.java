package com.movie.data.api.realdebrid;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class RealDebridModule_ProvideRestAdapterFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final RealDebridModule f31911a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f31912b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Gson> f31913c;

    public RealDebridModule_ProvideRestAdapterFactory(RealDebridModule realDebridModule, Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f31911a = realDebridModule;
        this.f31912b = provider;
        this.f31913c = provider2;
    }

    public static RealDebridModule_ProvideRestAdapterFactory a(RealDebridModule realDebridModule, Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new RealDebridModule_ProvideRestAdapterFactory(realDebridModule, provider, provider2);
    }

    public static Retrofit c(RealDebridModule realDebridModule, OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit) Preconditions.d(realDebridModule.e(okHttpClient, gson));
    }

    /* renamed from: b */
    public Retrofit get() {
        return c(this.f31911a, this.f31912b.get(), this.f31913c.get());
    }
}
