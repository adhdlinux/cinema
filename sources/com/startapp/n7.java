package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public final class n7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdEventListener f34957a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f34958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34959c;

    public n7(AdEventListener adEventListener, Ad ad, Context context) {
        this.f34957a = adEventListener;
        this.f34958b = ad;
        this.f34959c = context;
    }

    public void run() {
        try {
            this.f34957a.onReceiveAd(this.f34958b);
        } catch (Throwable th) {
            lb.a(this.f34959c, (Object) this.f34957a, th);
        }
    }
}
