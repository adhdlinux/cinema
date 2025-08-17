package com.movie.ui.fragment;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33325b;

    public /* synthetic */ d0(MovieFragment movieFragment) {
        this.f33325b = movieFragment;
    }

    public final void accept(Object obj) {
        this.f33325b.V0((MediaSource) obj);
    }
}
