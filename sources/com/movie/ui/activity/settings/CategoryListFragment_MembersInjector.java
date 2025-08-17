package com.movie.ui.activity.settings;

import com.database.MvDatabase;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.MembersInjector;

public final class CategoryListFragment_MembersInjector implements MembersInjector<CategoryListFragment> {
    public static void a(CategoryListFragment categoryListFragment, MvDatabase mvDatabase) {
        categoryListFragment.f32510f = mvDatabase;
    }

    public static void b(CategoryListFragment categoryListFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        categoryListFragment.f32511g = tMDBRepositoryImpl;
    }

    public static void c(CategoryListFragment categoryListFragment, TraktRepositoryImpl traktRepositoryImpl) {
        categoryListFragment.f32512h = traktRepositoryImpl;
    }
}
