package com.movie.data.api;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideGlobalOkHttpClientFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final ApiModule f31899a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Application> f31900b;

    public ApiModule_ProvideGlobalOkHttpClientFactory(ApiModule apiModule, Provider<Application> provider) {
        this.f31899a = apiModule;
        this.f31900b = provider;
    }

    public static ApiModule_ProvideGlobalOkHttpClientFactory a(ApiModule apiModule, Provider<Application> provider) {
        return new ApiModule_ProvideGlobalOkHttpClientFactory(apiModule, provider);
    }

    public static OkHttpClient c(ApiModule apiModule, Application application) {
        return (OkHttpClient) Preconditions.d(apiModule.c(application));
    }

    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f31899a, this.f31900b.get());
    }
}
