package com.vungle.ads;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerAd f37838b;

    public /* synthetic */ i(BannerAd bannerAd) {
        this.f37838b = bannerAd;
    }

    public final void run() {
        BannerAd$adPlayCallback$1.m120onAdImpression$lambda1(this.f37838b);
    }
}
