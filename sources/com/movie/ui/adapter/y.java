package com.movie.ui.adapter;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33152b;

    public /* synthetic */ y(Observer observer) {
        this.f33152b = observer;
    }

    public final void accept(Object obj) {
        this.f33152b.onComplete();
    }
}
