package com.movie.ui.activity.shows;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.ui.helper.MoviesHelper;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.MembersInjector;

public final class ShowActivity_MembersInjector implements MembersInjector<ShowActivity> {
    public static void a(ShowActivity showActivity, MoviesHelper moviesHelper) {
        showActivity.f32671c = moviesHelper;
    }

    public static void b(ShowActivity showActivity, MvDatabase mvDatabase) {
        showActivity.f32670b = mvDatabase;
    }

    public static void c(ShowActivity showActivity, TheTvdb theTvdb) {
        showActivity.f32673e = theTvdb;
    }

    public static void d(ShowActivity showActivity, TMDBApi tMDBApi) {
        showActivity.f32672d = tMDBApi;
    }
}
