package com.startapp;

import android.content.Context;
import com.startapp.lb;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public final class n8 implements lb.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdEventListener f34961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InterstitialAd f34962c;

    public n8(Context context, AdEventListener adEventListener, InterstitialAd interstitialAd) {
        this.f34960a = context;
        this.f34961b = adEventListener;
        this.f34962c = interstitialAd;
    }

    public void a(boolean z2, long j2, long j3, boolean z3) {
        p.b(this.f34960a, this.f34961b, (Ad) this.f34962c);
    }

    public void a(int i2, String str) {
        p.b(this.f34960a, this.f34961b, (Ad) this.f34962c);
    }
}
