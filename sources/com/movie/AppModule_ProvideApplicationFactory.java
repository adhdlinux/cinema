package com.movie;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideApplicationFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final AppModule f31845a;

    public AppModule_ProvideApplicationFactory(AppModule appModule) {
        this.f31845a = appModule;
    }

    public static AppModule_ProvideApplicationFactory a(AppModule appModule) {
        return new AppModule_ProvideApplicationFactory(appModule);
    }

    public static Application c(AppModule appModule) {
        return (Application) Preconditions.d(appModule.a());
    }

    /* renamed from: b */
    public Application get() {
        return c(this.f31845a);
    }
}
