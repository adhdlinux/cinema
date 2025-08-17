package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

public final class l7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdDisplayListener f34862a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f34863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34864c;

    public l7(AdDisplayListener adDisplayListener, Ad ad, Context context) {
        this.f34862a = adDisplayListener;
        this.f34863b = ad;
        this.f34864c = context;
    }

    public void run() {
        try {
            this.f34862a.adClicked(this.f34863b);
        } catch (Throwable th) {
            lb.a(this.f34864c, (Object) this.f34862a, th);
        }
    }
}
