package com.movie.ui.fragment;

import com.movie.data.api.realdebrid.RealDebridApi;
import dagger.MembersInjector;

public final class TorrentManagerFragment_MembersInjector implements MembersInjector<TorrentManagerFragment> {
    public static void a(TorrentManagerFragment torrentManagerFragment, RealDebridApi realDebridApi) {
        torrentManagerFragment.f33313d = realDebridApi;
    }
}
