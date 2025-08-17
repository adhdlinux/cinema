package com.movie.ui.fragment;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import dagger.MembersInjector;
import javax.inject.Named;
import okhttp3.OkHttpClient;

public final class MovieFragment_MembersInjector implements MembersInjector<MovieFragment> {
    public static void a(MovieFragment movieFragment, MoviesHelper moviesHelper) {
        movieFragment.f33251k = moviesHelper;
    }

    public static void b(MovieFragment movieFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        movieFragment.f33247g = tMDBRepositoryImpl;
    }

    public static void c(MovieFragment movieFragment, MoviesApi moviesApi) {
        movieFragment.f33249i = moviesApi;
    }

    public static void d(MovieFragment movieFragment, MvDatabase mvDatabase) {
        movieFragment.f33248h = mvDatabase;
    }

    public static void e(MovieFragment movieFragment, OpenSubtitleV1Api openSubtitleV1Api) {
        movieFragment.f33246f = openSubtitleV1Api;
    }

    @Named("MovieDetailsActivity")
    public static void f(MovieFragment movieFragment, PlayerHelper playerHelper) {
        movieFragment.f33254n = playerHelper;
    }

    @Named("RealDebrid")
    public static void g(MovieFragment movieFragment, OkHttpClient okHttpClient) {
        movieFragment.f33253m = okHttpClient;
    }

    public static void h(MovieFragment movieFragment, TMDBApi tMDBApi) {
        movieFragment.f33250j = tMDBApi;
    }
}
