package com.movie.ui.adapter;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33149b;

    public /* synthetic */ w(Observer observer) {
        this.f33149b = observer;
    }

    public final void accept(Object obj) {
        this.f33149b.onComplete();
    }
}
