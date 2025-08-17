package com.movie.ui.activity.sources.episodesPack;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class EpisodesActivity_MembersInjector implements MembersInjector<EpisodesActivity> {
    public static void a(EpisodesActivity episodesActivity, MoviesHelper moviesHelper) {
        episodesActivity.f32918g = moviesHelper;
    }

    public static void b(EpisodesActivity episodesActivity, MoviesApi moviesApi) {
        episodesActivity.f32921j = moviesApi;
    }

    public static void c(EpisodesActivity episodesActivity, MvDatabase mvDatabase) {
        episodesActivity.f32919h = mvDatabase;
    }

    @Named("EpisodeActivity")
    public static void d(EpisodesActivity episodesActivity, PlayerHelper playerHelper) {
        episodesActivity.f32922k = playerHelper;
    }

    public static void e(EpisodesActivity episodesActivity, RealDebridApi realDebridApi) {
        episodesActivity.f32920i = realDebridApi;
    }
}
