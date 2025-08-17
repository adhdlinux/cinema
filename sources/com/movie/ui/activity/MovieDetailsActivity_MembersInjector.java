package com.movie.ui.activity;

import com.movie.data.api.tmdb.TMDBApi;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class MovieDetailsActivity_MembersInjector implements MembersInjector<MovieDetailsActivity> {
    public static void a(MovieDetailsActivity movieDetailsActivity, MoviesHelper moviesHelper) {
        movieDetailsActivity.f32134k = moviesHelper;
    }

    @Named("MovieDetailsActivity")
    public static void b(MovieDetailsActivity movieDetailsActivity, PlayerHelper playerHelper) {
        movieDetailsActivity.f32136m = playerHelper;
    }

    public static void c(MovieDetailsActivity movieDetailsActivity, TMDBApi tMDBApi) {
        movieDetailsActivity.f32133j = tMDBApi;
    }
}
