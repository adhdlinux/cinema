package com.movie.ui.adapter;

import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33146b;

    public /* synthetic */ u(MoviesAdapter.MovieHolder movieHolder) {
        this.f33146b = movieHolder;
    }

    public final void accept(Object obj) {
        this.f33146b.w((Throwable) obj);
    }
}
