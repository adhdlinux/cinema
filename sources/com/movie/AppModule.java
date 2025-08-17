package com.movie;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class AppModule {

    /* renamed from: a  reason: collision with root package name */
    private final FreeMoviesApp f31844a;

    public AppModule(FreeMoviesApp freeMoviesApp) {
        this.f31844a = freeMoviesApp;
    }

    /* access modifiers changed from: package-private */
    @Singleton
    @Provides
    public Application a() {
        return this.f31844a;
    }
}
