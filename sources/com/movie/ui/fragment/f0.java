package com.movie.ui.fragment;

import com.movie.data.model.cinema.Video;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33329b;

    public /* synthetic */ f0(MovieFragment movieFragment) {
        this.f33329b = movieFragment;
    }

    public final void accept(Object obj) {
        this.f33329b.C0((Video.Response) obj);
    }
}
