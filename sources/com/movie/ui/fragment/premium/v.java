package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33580b;

    public /* synthetic */ v(TorrentAdapterListFragment torrentAdapterListFragment) {
        this.f33580b = torrentAdapterListFragment;
    }

    public final void accept(Object obj) {
        this.f33580b.v0((TorrentObject) obj);
    }
}
