package com.movie.ui.adapter;

import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33136b;

    public /* synthetic */ o(Observer observer) {
        this.f33136b = observer;
    }

    public final void accept(Object obj) {
        MoviesAdapter.MovieHolder.C(this.f33136b, (MoviesAdapter.MovieHolder.HolderImage) obj);
    }
}
