package com.movie.ui.activity.shows.overview;

import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.MembersInjector;

public final class OverviewFragment_MembersInjector implements MembersInjector<OverviewFragment> {
    public static void a(OverviewFragment overviewFragment, MoviesHelper moviesHelper) {
        overviewFragment.f32769j = moviesHelper;
    }

    public static void b(OverviewFragment overviewFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        overviewFragment.f32766g = tMDBRepositoryImpl;
    }

    public static void c(OverviewFragment overviewFragment, TheTvdb theTvdb) {
        overviewFragment.f32768i = theTvdb;
    }

    public static void d(OverviewFragment overviewFragment, TMDBApi tMDBApi) {
        overviewFragment.f32765f = tMDBApi;
    }
}
