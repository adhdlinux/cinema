package com.movie.ui.helper;

import com.database.MvDatabase;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MoviesHelper_ProviderMoviesHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final MoviesHelper f33632a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TMDBRepositoryImpl> f33633b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MvDatabase> f33634c;

    public MoviesHelper_ProviderMoviesHelperFactory(MoviesHelper moviesHelper, Provider<TMDBRepositoryImpl> provider, Provider<MvDatabase> provider2) {
        this.f33632a = moviesHelper;
        this.f33633b = provider;
        this.f33634c = provider2;
    }

    public static MoviesHelper_ProviderMoviesHelperFactory a(MoviesHelper moviesHelper, Provider<TMDBRepositoryImpl> provider, Provider<MvDatabase> provider2) {
        return new MoviesHelper_ProviderMoviesHelperFactory(moviesHelper, provider, provider2);
    }

    public static MoviesHelper c(MoviesHelper moviesHelper, TMDBRepositoryImpl tMDBRepositoryImpl, MvDatabase mvDatabase) {
        return (MoviesHelper) Preconditions.d(moviesHelper.j(tMDBRepositoryImpl, mvDatabase));
    }

    /* renamed from: b */
    public MoviesHelper get() {
        return c(this.f33632a, this.f33633b.get(), this.f33634c.get());
    }
}
