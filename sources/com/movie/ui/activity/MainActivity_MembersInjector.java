package com.movie.ui.activity;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    public static void a(MainActivity mainActivity, MoviesApi moviesApi) {
        mainActivity.f32038h = moviesApi;
    }

    public static void b(MainActivity mainActivity, MvDatabase mvDatabase) {
        mainActivity.f32037g = mvDatabase;
    }

    @Named("MainActivity")
    public static void c(MainActivity mainActivity, PlayerHelper playerHelper) {
        mainActivity.f32039i = playerHelper;
    }

    public static void d(MainActivity mainActivity, TMDBRepositoryImpl tMDBRepositoryImpl) {
        mainActivity.f32035e = tMDBRepositoryImpl;
    }

    public static void e(MainActivity mainActivity, TraktRepositoryImpl traktRepositoryImpl) {
        mainActivity.f32036f = traktRepositoryImpl;
    }
}
