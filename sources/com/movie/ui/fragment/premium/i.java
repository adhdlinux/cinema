package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33565b;

    public /* synthetic */ i(TorrentAdapterListFragment torrentAdapterListFragment) {
        this.f33565b = torrentAdapterListFragment;
    }

    public final void accept(Object obj) {
        this.f33565b.t0((TorrentObject) obj);
    }
}
