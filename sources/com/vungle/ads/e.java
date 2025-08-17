package com.vungle.ads;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerAd f37833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37834c;

    public /* synthetic */ e(BannerAd bannerAd, VungleError vungleError) {
        this.f37833b = bannerAd;
        this.f37834c = vungleError;
    }

    public final void run() {
        BannerAd.m117getBannerView$lambda1(this.f37833b, this.f37834c);
    }
}
