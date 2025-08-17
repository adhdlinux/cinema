package com.vungle.ads;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAd f37940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37941c;

    public /* synthetic */ l(BaseAd baseAd, VungleError vungleError) {
        this.f37940b = baseAd;
        this.f37941c = vungleError;
    }

    public final void run() {
        BaseAd.m127onLoadFailure$lambda2(this.f37940b, this.f37941c);
    }
}
