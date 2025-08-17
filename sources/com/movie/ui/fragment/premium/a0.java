package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TorrentAdapterListFragment f33528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TorrentObject f33529c;

    public /* synthetic */ a0(TorrentAdapterListFragment torrentAdapterListFragment, TorrentObject torrentObject) {
        this.f33528b = torrentAdapterListFragment;
        this.f33529c = torrentObject;
    }

    public final void accept(Object obj) {
        this.f33528b.r0(this.f33529c, (List) obj);
    }
}
