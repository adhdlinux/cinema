package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

public final class q3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerListener f35643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f35644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f35645c;

    public q3(BannerListener bannerListener, View view, Context context) {
        this.f35643a = bannerListener;
        this.f35644b = view;
        this.f35645c = context;
    }

    public void run() {
        try {
            this.f35643a.onClick(this.f35644b);
        } catch (Throwable th) {
            lb.a(this.f35645c, (Object) this.f35643a, th);
        }
    }
}
