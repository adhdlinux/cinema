package com.movie.ui.fragment;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.MembersInjector;

public final class MoviesFragment_MembersInjector implements MembersInjector<MoviesFragment> {
    public static void a(MoviesFragment moviesFragment, IMDBApi iMDBApi) {
        moviesFragment.f33297h = iMDBApi;
    }

    public static void b(MoviesFragment moviesFragment, MoviesHelper moviesHelper) {
        moviesFragment.f33302m = moviesHelper;
    }

    public static void c(MoviesFragment moviesFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        moviesFragment.f33293d = tMDBRepositoryImpl;
    }

    public static void d(MoviesFragment moviesFragment, MoviesApi moviesApi) {
        moviesFragment.f33294e = moviesApi;
    }

    public static void e(MoviesFragment moviesFragment, MvDatabase mvDatabase) {
        moviesFragment.f33295f = mvDatabase;
    }

    public static void f(MoviesFragment moviesFragment, TheTvdb theTvdb) {
        moviesFragment.f33298i = theTvdb;
    }

    public static void g(MoviesFragment moviesFragment, TMDBApi tMDBApi) {
        moviesFragment.f33296g = tMDBApi;
    }
}
