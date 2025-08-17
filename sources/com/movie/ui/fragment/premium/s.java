package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33577c;

    public /* synthetic */ s(TorrentAdapterListFragment torrentAdapterListFragment, TorrentObject torrentObject) {
        this.f33576b = torrentAdapterListFragment;
        this.f33577c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33576b.k0(this.f33577c, obj);
    }
}
