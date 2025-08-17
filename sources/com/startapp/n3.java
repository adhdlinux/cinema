package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

public final class n3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerListener f34950a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f34951b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34952c;

    public n3(BannerListener bannerListener, View view, Context context) {
        this.f34950a = bannerListener;
        this.f34951b = view;
        this.f34952c = context;
    }

    public void run() {
        try {
            this.f34950a.onReceiveAd(this.f34951b);
        } catch (Throwable th) {
            lb.a(this.f34952c, (Object) this.f34950a, th);
        }
    }
}
