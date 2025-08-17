package com.movie.ui.adapter;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33116b;

    public /* synthetic */ c(Observer observer) {
        this.f33116b = observer;
    }

    public final void accept(Object obj) {
        this.f33116b.onComplete();
    }
}
