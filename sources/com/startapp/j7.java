package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

public final class j7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdDisplayListener f34740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f34741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34742c;

    public j7(AdDisplayListener adDisplayListener, Ad ad, Context context) {
        this.f34740a = adDisplayListener;
        this.f34741b = ad;
        this.f34742c = context;
    }

    public void run() {
        try {
            this.f34740a.adHidden(this.f34741b);
        } catch (Throwable th) {
            lb.a(this.f34742c, (Object) this.f34740a, th);
        }
    }
}
