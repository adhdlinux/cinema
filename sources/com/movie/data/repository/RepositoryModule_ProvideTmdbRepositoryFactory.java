package com.movie.data.repository;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class RepositoryModule_ProvideTmdbRepositoryFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final RepositoryModule f31950a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TMDBApi> f31951b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MvDatabase> f31952c;

    public RepositoryModule_ProvideTmdbRepositoryFactory(RepositoryModule repositoryModule, Provider<TMDBApi> provider, Provider<MvDatabase> provider2) {
        this.f31950a = repositoryModule;
        this.f31951b = provider;
        this.f31952c = provider2;
    }

    public static RepositoryModule_ProvideTmdbRepositoryFactory a(RepositoryModule repositoryModule, Provider<TMDBApi> provider, Provider<MvDatabase> provider2) {
        return new RepositoryModule_ProvideTmdbRepositoryFactory(repositoryModule, provider, provider2);
    }

    public static TMDBRepositoryImpl c(RepositoryModule repositoryModule, TMDBApi tMDBApi, MvDatabase mvDatabase) {
        return (TMDBRepositoryImpl) Preconditions.d(repositoryModule.a(tMDBApi, mvDatabase));
    }

    /* renamed from: b */
    public TMDBRepositoryImpl get() {
        return c(this.f31950a, this.f31951b.get(), this.f31952c.get());
    }
}
