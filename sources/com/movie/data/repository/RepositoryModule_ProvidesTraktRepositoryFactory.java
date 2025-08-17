package com.movie.data.repository;

import com.database.MvDatabase;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class RepositoryModule_ProvidesTraktRepositoryFactory implements Provider {
    public static TraktRepositoryImpl a(RepositoryModule repositoryModule, MvDatabase mvDatabase) {
        return (TraktRepositoryImpl) Preconditions.d(repositoryModule.b(mvDatabase));
    }
}
