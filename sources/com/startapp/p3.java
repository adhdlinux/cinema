package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

public final class p3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerListener f35600a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f35601b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f35602c;

    public p3(BannerListener bannerListener, View view, Context context) {
        this.f35600a = bannerListener;
        this.f35601b = view;
        this.f35602c = context;
    }

    public void run() {
        try {
            this.f35600a.onImpression(this.f35601b);
        } catch (Throwable th) {
            lb.a(this.f35602c, (Object) this.f35600a, th);
        }
    }
}
