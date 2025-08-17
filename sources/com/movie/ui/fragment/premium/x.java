package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33583b;

    public /* synthetic */ x(TorrentAdapterListFragment torrentAdapterListFragment) {
        this.f33583b = torrentAdapterListFragment;
    }

    public final void accept(Object obj) {
        this.f33583b.x0((TorrentObject) obj);
    }
}
