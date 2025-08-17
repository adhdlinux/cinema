package com.database;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class DatabaseModule {
    /* access modifiers changed from: package-private */
    @Singleton
    @Provides
    public MvDatabase a(Application application) {
        return MvDatabase.z(application);
    }
}
