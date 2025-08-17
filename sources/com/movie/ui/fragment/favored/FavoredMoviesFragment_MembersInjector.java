package com.movie.ui.fragment.favored;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import dagger.MembersInjector;

public final class FavoredMoviesFragment_MembersInjector implements MembersInjector<FavoredMoviesFragment> {
    public static void a(FavoredMoviesFragment favoredMoviesFragment, MvDatabase mvDatabase) {
        favoredMoviesFragment.f33331u = mvDatabase;
    }

    public static void b(FavoredMoviesFragment favoredMoviesFragment, TMDBApi tMDBApi) {
        favoredMoviesFragment.f33332v = tMDBApi;
    }
}
