package com.vungle.ads;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseFullscreenAd f37949b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37950c;

    public /* synthetic */ t(BaseFullscreenAd baseFullscreenAd, VungleError vungleError) {
        this.f37949b = baseFullscreenAd;
        this.f37950c = vungleError;
    }

    public final void run() {
        BaseFullscreenAd$play$2.m135onFailure$lambda6(this.f37949b, this.f37950c);
    }
}
