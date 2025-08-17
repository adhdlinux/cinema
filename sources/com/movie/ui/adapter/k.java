package com.movie.ui.adapter;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33129b;

    public /* synthetic */ k(Observer observer) {
        this.f33129b = observer;
    }

    public final void accept(Object obj) {
        this.f33129b.onComplete();
    }
}
