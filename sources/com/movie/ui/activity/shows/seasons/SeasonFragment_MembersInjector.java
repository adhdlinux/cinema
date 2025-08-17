package com.movie.ui.activity.shows.seasons;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.MembersInjector;

public final class SeasonFragment_MembersInjector implements MembersInjector<SeasonFragment> {
    public static void a(SeasonFragment seasonFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        seasonFragment.f32780h = tMDBRepositoryImpl;
    }

    public static void b(SeasonFragment seasonFragment, MoviesApi moviesApi) {
        seasonFragment.f32784l = moviesApi;
    }

    public static void c(SeasonFragment seasonFragment, MvDatabase mvDatabase) {
        seasonFragment.f32782j = mvDatabase;
    }

    public static void d(SeasonFragment seasonFragment, TheTvdb theTvdb) {
        seasonFragment.f32781i = theTvdb;
    }

    public static void e(SeasonFragment seasonFragment, TMDBApi tMDBApi) {
        seasonFragment.f32783k = tMDBApi;
    }
}
