package com.movie.ui.fragment;

import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrowseMoviesFragment f33321b;

    public /* synthetic */ a(BrowseMoviesFragment browseMoviesFragment) {
        this.f33321b = browseMoviesFragment;
    }

    public final void accept(Object obj) {
        this.f33321b.U((List) obj);
    }
}
