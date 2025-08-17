package com.movie.data.repository;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public final class RepositoryModule {
    @Provides
    public TMDBRepositoryImpl a(TMDBApi tMDBApi, MvDatabase mvDatabase) {
        return new TMDBRepositoryImpl(tMDBApi, mvDatabase);
    }

    @Provides
    public TraktRepositoryImpl b(MvDatabase mvDatabase) {
        return new TraktRepositoryImpl(mvDatabase);
    }
}
