package com.movie.ui.fragment.mylist;

import com.database.MvDatabase;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.MembersInjector;

public final class MyListFragment_MembersInjector implements MembersInjector<MyListFragment> {
    public static void a(MyListFragment myListFragment, MvDatabase mvDatabase) {
        myListFragment.f33379d = mvDatabase;
    }

    public static void b(MyListFragment myListFragment, TraktRepositoryImpl traktRepositoryImpl) {
        myListFragment.f33380e = traktRepositoryImpl;
    }
}
