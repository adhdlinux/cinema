package com.movie.ui.activity.shows.seasons;

import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f32841b;

    public /* synthetic */ n(ObservableEmitter observableEmitter) {
        this.f32841b = observableEmitter;
    }

    public final void accept(Object obj) {
        this.f32841b.onComplete();
    }
}
