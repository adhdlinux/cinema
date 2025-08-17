package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33573b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33574c;

    public /* synthetic */ q(TorrentAdapterListFragment torrentAdapterListFragment, TorrentObject torrentObject) {
        this.f33573b = torrentAdapterListFragment;
        this.f33574c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33573b.o0(this.f33574c, obj);
    }
}
