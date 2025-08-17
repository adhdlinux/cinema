package com.vungle.ads.internal.presenter;

import com.vungle.ads.VungleError;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MRAIDPresenter f37908b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37909c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f37910d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f37911e;

    public /* synthetic */ d(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z2, String str) {
        this.f37908b = mRAIDPresenter;
        this.f37909c = vungleError;
        this.f37910d = z2;
        this.f37911e = str;
    }

    public final void run() {
        MRAIDPresenter.m200processCommand$lambda12(this.f37908b, this.f37909c, this.f37910d, this.f37911e);
    }
}
