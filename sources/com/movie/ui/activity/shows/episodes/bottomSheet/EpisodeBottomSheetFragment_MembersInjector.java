package com.movie.ui.activity.shows.episodes.bottomSheet;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import dagger.MembersInjector;

public final class EpisodeBottomSheetFragment_MembersInjector implements MembersInjector<EpisodeBottomSheetFragment> {
    public static void a(EpisodeBottomSheetFragment episodeBottomSheetFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        episodeBottomSheetFragment.f32705b = tMDBRepositoryImpl;
    }

    public static void b(EpisodeBottomSheetFragment episodeBottomSheetFragment, MvDatabase mvDatabase) {
        episodeBottomSheetFragment.f32706c = mvDatabase;
    }

    public static void c(EpisodeBottomSheetFragment episodeBottomSheetFragment, TMDBApi tMDBApi) {
        episodeBottomSheetFragment.f32707d = tMDBApi;
    }
}
