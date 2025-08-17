package com.vungle.ads.internal.presenter;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MRAIDPresenter f37913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f37914c;

    public /* synthetic */ f(MRAIDPresenter mRAIDPresenter, long j2) {
        this.f37913b = mRAIDPresenter;
        this.f37914c = j2;
    }

    public final void run() {
        MRAIDPresenter.m202processCommand$lambda14(this.f37913b, this.f37914c);
    }
}
