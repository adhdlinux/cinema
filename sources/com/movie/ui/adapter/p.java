package com.movie.ui.adapter;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33137b;

    public /* synthetic */ p(Observer observer) {
        this.f33137b = observer;
    }

    public final void accept(Object obj) {
        this.f33137b.onComplete();
    }
}
