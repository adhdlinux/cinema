package com.movie.ui.activity.shows.episodes.pageviewDialog;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import dagger.MembersInjector;

public final class PageViewDialog_MembersInjector implements MembersInjector<PageViewDialog> {
    public static void a(PageViewDialog pageViewDialog, TMDBRepositoryImpl tMDBRepositoryImpl) {
        pageViewDialog.f32743c = tMDBRepositoryImpl;
    }

    public static void b(PageViewDialog pageViewDialog, MvDatabase mvDatabase) {
        pageViewDialog.f32744d = mvDatabase;
    }

    public static void c(PageViewDialog pageViewDialog, TMDBApi tMDBApi) {
        pageViewDialog.f32745e = tMDBApi;
    }
}
