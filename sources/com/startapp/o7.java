package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public final class o7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdEventListener f35554a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f35555b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f35556c;

    public o7(AdEventListener adEventListener, Ad ad, Context context) {
        this.f35554a = adEventListener;
        this.f35555b = ad;
        this.f35556c = context;
    }

    public void run() {
        try {
            this.f35554a.onFailedToReceiveAd(this.f35555b);
        } catch (Throwable th) {
            lb.a(this.f35556c, (Object) this.f35554a, th);
        }
    }
}
