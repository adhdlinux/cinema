package com.movie.ui.fragment;

import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.MembersInjector;

public final class BrowseMoviesFragment_MembersInjector implements MembersInjector<BrowseMoviesFragment> {
    public static void a(BrowseMoviesFragment browseMoviesFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        browseMoviesFragment.A = tMDBRepositoryImpl;
    }

    public static void b(BrowseMoviesFragment browseMoviesFragment, TraktRepositoryImpl traktRepositoryImpl) {
        browseMoviesFragment.B = traktRepositoryImpl;
    }
}
