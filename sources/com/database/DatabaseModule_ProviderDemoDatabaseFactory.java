package com.database;

import android.app.Application;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProviderDemoDatabaseFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseModule f19194a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Application> f19195b;

    public DatabaseModule_ProviderDemoDatabaseFactory(DatabaseModule databaseModule, Provider<Application> provider) {
        this.f19194a = databaseModule;
        this.f19195b = provider;
    }

    public static DatabaseModule_ProviderDemoDatabaseFactory a(DatabaseModule databaseModule, Provider<Application> provider) {
        return new DatabaseModule_ProviderDemoDatabaseFactory(databaseModule, provider);
    }

    public static MvDatabase c(DatabaseModule databaseModule, Application application) {
        return (MvDatabase) Preconditions.d(databaseModule.a(application));
    }

    /* renamed from: b */
    public MvDatabase get() {
        return c(this.f19194a, this.f19195b.get());
    }
}
