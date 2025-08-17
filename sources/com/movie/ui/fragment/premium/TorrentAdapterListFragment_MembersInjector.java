package com.movie.ui.fragment.premium;

import com.database.MvDatabase;
import com.movie.data.api.realdebrid.RealDebridApi;
import dagger.MembersInjector;

public final class TorrentAdapterListFragment_MembersInjector implements MembersInjector<TorrentAdapterListFragment> {
    public static void a(TorrentAdapterListFragment torrentAdapterListFragment, MvDatabase mvDatabase) {
        torrentAdapterListFragment.f33496e = mvDatabase;
    }

    public static void b(TorrentAdapterListFragment torrentAdapterListFragment, RealDebridApi realDebridApi) {
        torrentAdapterListFragment.f33497f = realDebridApi;
    }
}
