package com.movie.ui.fragment;

import io.reactivex.functions.Action;

public final /* synthetic */ class o implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33451b;

    public /* synthetic */ o(MovieFragment movieFragment) {
        this.f33451b = movieFragment;
    }

    public final void run() {
        this.f33451b.hideWaitingDialog();
    }
}
