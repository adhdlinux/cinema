package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33570b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33571c;

    public /* synthetic */ o(TorrentAdapterListFragment torrentAdapterListFragment, TorrentObject torrentObject) {
        this.f33570b = torrentAdapterListFragment;
        this.f33571c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33570b.m0(this.f33571c, obj);
    }
}
