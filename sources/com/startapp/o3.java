package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

public final class o3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerListener f35546a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f35547b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f35548c;

    public o3(BannerListener bannerListener, View view, Context context) {
        this.f35546a = bannerListener;
        this.f35547b = view;
        this.f35548c = context;
    }

    public void run() {
        try {
            this.f35546a.onFailedToReceiveAd(this.f35547b);
        } catch (Throwable th) {
            lb.a(this.f35548c, (Object) this.f35546a, th);
        }
    }
}
