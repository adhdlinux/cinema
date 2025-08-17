package com.vungle.ads;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerAd f37937b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VungleError f37938c;

    public /* synthetic */ j(BannerAd bannerAd, VungleError vungleError) {
        this.f37937b = bannerAd;
        this.f37938c = vungleError;
    }

    public final void run() {
        BannerAd$adPlayCallback$1.m123onFailure$lambda5(this.f37937b, this.f37938c);
    }
}
